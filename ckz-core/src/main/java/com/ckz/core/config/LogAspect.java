package com.ckz.core.config;

import com.alibaba.fastjson.JSON;
import com.ckz.core.entity.Log;
import com.ckz.core.service.LogService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;

/**aop加上入參日志的打印
 * @author: caikaizhen
 * @date: 2018/11/27 18:19
 * @Description:
 */
@Component
@Aspect
@Slf4j
@Order(3)
public class LogAspect {


    @Pointcut("@annotation(com.ckz.core.annotation.SystemLog)")
    public void LogPointCut() {
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void requestMappingLog() {
    }

    @Pointcut("@annotation(io.swagger.annotations.ApiOperation)")
    public void ApiOperationLog() {
    }

    @Before("LogPointCut()")
    public void beforMethod(JoinPoint joinPoint) {
        try {
            Method method = getMethod(joinPoint);
            Annotation[] declaredAnnotations = method.getDeclaredAnnotations();

            HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            StringBuffer requestURL = req.getRequestURL();

            StringBuilder sb = new StringBuilder();
            sb.append(System.getProperty("line.separator")+"RequestURL===>"+requestURL.toString()+";"+System.getProperty("line.separator")+"");
            sb.append("ClassName===>"+joinPoint.getTarget().getClass().getTypeName()+";"+System.getProperty("line.separator")+"");
            Arrays.stream(declaredAnnotations).forEach(annotation-> {
                if(ApiOperation.class.equals(annotation.annotationType())){
                    ApiOperation apiOperation = (ApiOperation) annotation;
                    sb.append("访问方法为====>"+apiOperation.value()+":"+joinPoint.getSignature().getName()+";"+System.getProperty("line.separator")+"");
                }
            });
            Object[] args = joinPoint.getArgs();
            Arrays.stream(args).filter(a->{
                if(a instanceof ServletRequest){
                    return false;
                }
                return true;
            }).forEach(a->{
                sb.append("method parameter====>"+JSON.toJSONString(a)+";"+System.getProperty("line.separator")+"");
            });
            log.info(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /**
     * 获取当前执行的方法
     *
     * @param joinPoint 连接点
     * @return 方法
     */
    private Method getMethod(JoinPoint joinPoint) {
        //获取方法签名
        String methodName = joinPoint.getSignature().getName();
        //获取目标类的所有方法
        Method[] methods = joinPoint.getTarget().getClass().getMethods();
        Method resultMethod = null;
        //查询当前调用的方法
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                //找到当前要执行的方法
                resultMethod = method;
                break;
            }
        }
        return resultMethod;
    }








    // 注入Service用于把日志保存数据库
    @Autowired
    private LogService logService;

    @Resource(name="IOThreadPool")
    private ExecutorService IOThreadPool;

    /**
     * 后置通知 用于拦截Controller层记录用户的操作
     *
     * @param joinPoint
     *            切点
     * @param rvt
     *          指定一个 returning 属性，该属性值为 rvt , 表示 允许在 增强处理方法中使用名为rvt的形参，该形参代表目标方法的返回值。
     */
    @AfterReturning(returning = "rvt", pointcut = "requestMappingLog()&&ApiOperationLog()")
    public void AfterReturning(JoinPoint joinPoint, Object rvt) {
        Log operLog =new Log();
        operLog = operLog.transformLog(joinPoint, null,logService);
        IOThreadPool.submit(operLog);
    }


    @AfterThrowing(throwing="rvt",pointcut ="requestMappingLog()")
    public void AfterThrowing(JoinPoint joinPoint, Exception rvt){
        Log operLog =new Log();
        operLog = operLog.transformLog(joinPoint, rvt,logService);
        IOThreadPool.submit(operLog);
    }
}
