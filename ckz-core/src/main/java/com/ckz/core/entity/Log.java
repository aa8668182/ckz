package com.ckz.core.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ckz.core.common.BaseEntity;
import com.ckz.core.enums.LogStatusEnum;
import com.ckz.core.service.LogService;
import com.ckz.core.utils.IpUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Enumeration;

/**
 * @author: caikaizhen
 * @date: 2018/11/29 22:37
 * @Description:
 */
@TableName("mp_log")
@Data
@ApiModel(value="Log",description="日志记录表")
@Slf4j
public class Log extends BaseEntity implements Runnable{

    private static final long serialVersionUID = 1L;


    // 注入Service用于把日志保存数据库
    @TableField(exist = false)
    private LogService logService;

    @TableId
    @ApiModelProperty(value="日志id，主键自增")
    private Long id;


    //是否删除状态，1：删除，0：有效
    @TableField("user_id")
    @ApiModelProperty(value="操作用户ID")
    private String userId;

    @TableField("user_name")
    @ApiModelProperty(value="操作人名称")
    private String userName;

    @TableField("oper_time")
    @ApiModelProperty(value="操作时间(yyyy-MM-dd HH:mm:ss)")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date operTime;

    @TableField("client_ip")
    @ApiModelProperty(value="登录IP")
    private String clientIp;

    @TableField("req_url")
    @ApiModelProperty(value="访问url")
    private String reqUrl;


    @TableField("method")
    @ApiModelProperty(value="请求方法")
    private String method;

    @TableField("oper_event")
    @ApiModelProperty(value="操作事件（删除，新增，修改，查询，登录，退出）")
    private String operEvent;

    @TableField("oper_status")
    @ApiModelProperty(value="操作状态（1：成功，2：失败）")
    private int operStatus;

    @TableField("log_desc")
    @ApiModelProperty(value="描述信息")
    private String logDesc;

    @TableField("app_version")
    @ApiModelProperty(value="app版本")
    private String appVersion;



    /**
     * 从切点中获取信息 放入operlog中
     * @param joinPoint
     * @param e
     * @return
     */
    public Log transformLog(JoinPoint joinPoint, Exception e,LogService logService){
        this.logService=logService;

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        Log operLog = this;
        StringBuffer operEvent = new StringBuffer();

        try {
            String targetName = joinPoint.getTarget().getClass().getName(); // 请求类名称
            String methodName = joinPoint.getSignature().getName(); // 请求方法
            Object[] arguments = joinPoint.getArgs();
            Class<?> targetClass = null;
            targetClass = Class.forName(targetName);

            Method[] methods = targetClass.getMethods();
            for (Method method : methods) {
                if (method.getName().equals(methodName)) {
                    Class[] clazzs = method.getParameterTypes();
                    if (clazzs.length == arguments.length) {
                        if(method.getAnnotation(ApiOperation.class) != null){ // 如果包含注解@log() systemlog
                            operEvent.append(method.getAnnotation(ApiOperation.class).value());
                            operEvent.append("。");
                            break;
                        }
                    }
                }
            }

            if(joinPoint.getArgs().length > 0){
                operEvent.append("该方法实际入参为：");
                for (int i = 0; i < joinPoint.getArgs().length; i++) {
                    Object arg = joinPoint.getArgs()[i];
                    if(arg instanceof ServletRequest){
                        continue;
                    }
                    operEvent.append(arg);
                    operEvent.append(",");
                }
                operEvent.deleteCharAt(operEvent.length()-1); //删除最后一个 ","
                operEvent.append("。");
            }
            if(e != null){
                operEvent.append("Exception类型为：");
                operEvent.append(e.getClass());
                operLog.setLogDesc("具体Exception信息为："+ createExceptionDetail(e));
            }

            Enumeration<String> enums = request.getHeaderNames();
            while (enums.hasMoreElements()) {
                String headerName = enums.nextElement();//透明称
                String headerValues = request.getHeader(headerName);
                if ("appversion".equals(headerName)) {
                    operLog.setAppVersion(headerValues);
                }
                if ("userid".equals(headerName)) {
                    operLog.setUserId(headerValues);
                }
            }
            operLog.setClientIp(IpUtils.getIpAddr(request));
        }catch (ClassNotFoundException e1) {
            e1.printStackTrace();
            log.error("实例化失败：ClassNotFoundException");
        }catch (Exception e3){
            e3.printStackTrace();
        }

        operLog.setOperTime(new Date());
        operLog.setReqUrl(request.getRequestURI());
        operLog.setMethod(joinPoint.getSignature().getDeclaringTypeName()+","+joinPoint.getSignature().getName());
        operLog.setOperEvent((operEvent.toString()).length()>1000?(operEvent.toString()).substring(0,1000):operEvent.toString());
        if(e != null){
            operLog.setOperStatus(LogStatusEnum.OPER_LOG_STATUS_FAIL.getValue());
        }else{
            operLog.setOperStatus(LogStatusEnum.OPER_LOG_STATUS_SUCCESS.getValue());
        }
        return operLog;
    }





    /**
     * 异常数组转成字符串
     *
     * @param e
     * @return
     * @author
     * @2016-8-18 下午5:43:20
     */
    private String createExceptionDetail(Exception e) {
        e.printStackTrace();
        StackTraceElement[] stackTraceArray = e.getStackTrace();
        StringBuilder detail = new StringBuilder();
        for (int i = 0; i < stackTraceArray.length; i++) {
            //800位，此处是考虑数据库相应字段的大小限制
            if((detail.toString()+stackTraceArray[i]).length() > 1000){
                return detail.toString();
            }
            detail.append(stackTraceArray[i] + "\r\n");
        }
        return detail.toString();
    }


    @Override
    public void run() {
        try {
            if(logService!=null){
                logService.save(this);
            }
        } catch (Exception e) {
            //打印控制台
            e.printStackTrace();
        }

    }
}