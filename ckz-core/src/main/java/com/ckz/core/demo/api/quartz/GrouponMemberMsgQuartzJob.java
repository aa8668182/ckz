package com.qianmi.marketing.groupon.quartz;

import com.ningpai.common.util.ApplicationContextHelper;
import com.ningpai.common.util.DateUtil;
import com.qianmi.common.Constants;
import com.qianmi.marketing.groupon.bean.TaskJob;
import com.qianmi.marketing.groupon.service.MarketingGrouponInstService;
import com.qianmi.marketing.groupon.service.MarketingGrouponOrderService;
import com.qianmi.marketing.groupon.vo.MarketingGrouponInstVo;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 拼团订单实时24小时定时任务
 * Created by wg on 2017/5/31.
 */
@Slf4j
@Component
public class GrouponMemberMsgQuartzJob implements Job {



    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        //获取团编号或者团实例ID
        JobDataMap dataMap = context.getMergedJobDataMap();
        String grouponNo = dataMap.getString("bizId");
        Integer jobId =  dataMap.getInt("jobId");
        log.info("团编号："+grouponNo+">>>定时任务开始运行！");
        //根据以上信息查询团活动是否过期/或者是否已经超过成团时间
        MarketingGrouponInstService marketingGrouponInstService =  (MarketingGrouponInstService)ApplicationContextHelper.getBean("marketingGrouponInstService");
        MarketingGrouponInstVo marketingGrouponInstVo = marketingGrouponInstService.queryMarketingGrouponInstByGrouponNo(grouponNo);
        //已成团/团已作废不作处理
        if (marketingGrouponInstVo.getStatus() == Constants.MarketingGroupon.ORDER_MARKETING_GROUPON_COMPLETE || marketingGrouponInstVo.getStatus() == Constants.MarketingGroupon.ORDER_MARKETING_GROUPON_DEL){
            //移除当前团编号的定时任务,并更新数据库状态信息
            updateTaskJobAndMoveFromScheduler(grouponNo,jobId);
            log.info("团编号："+grouponNo+">>>已成团或者已作废，移除当前团编号的定时任务,并更新数据库该任务状态！");
            return;
        }else{
            Date endTime =  marketingGrouponInstService.getMarketingGrouponMemberMsgTime(marketingGrouponInstVo.getStartTime(),marketingGrouponInstVo.getMarketing().getEndTime());
            //倒计时结束（已超团结束时长24小时）,需将该拼团订单作废，并发短信通知
            if (endTime.getTime() < DateUtil.now().getTime()  && marketingGrouponInstVo.getStatus() == Constants.MarketingGroupon.ORDER_MARKETING_GROUPON_STATUS){
                //发送参团人数不足提醒消息
                MarketingGrouponOrderService marketingGrouponOrderService =  (MarketingGrouponOrderService) ApplicationContextHelper.getBean("marketingGrouponOrderService");
                marketingGrouponOrderService.sendWechatTmpMsgGrouponMember(grouponNo);
                //移除当前团编号的定时任务,并更新数据库状态信息
                updateTaskJobAndMoveFromScheduler(grouponNo,jobId);
                log.info("团编号："+grouponNo+">>>倒计时结束（已超团结束时长24小时）,需将该拼团订单作废，并发短信通知！");
                return;
            }
            //后台修改了拼团活动的结束时间，导致该拼团还未超时，修改当前任务的触发时间，等待下次触发时间
            QuartzManagerService quartzManagerService  =  (QuartzManagerService)ApplicationContextHelper.getBean("quartzManagerService");
            quartzManagerService.modifyJobTime(grouponNo,Constants.MarketingGroupon.JOB_GROUP_MEMBER_MSG,DateUtil.dateToString(endTime,"ss mm HH dd")+DateUtil.dateToString(endTime," MM")+" ? *");
            log.info("团编号："+grouponNo+">>>后台修改了拼团活动的结束时间，导致该拼团还未超时，，修改当前任务的触发时间，等待下次触发时间！");
        }
    }

    /**
     * 更新任务信息，并且删除该定时任务
     * @param grouponNo
     * @param jobId
     */
    private void updateTaskJobAndMoveFromScheduler(String grouponNo,Integer jobId){
        //移除当前团编号的定时任务
        QuartzManagerService quartzManagerService  =  (QuartzManagerService)ApplicationContextHelper.getBean("quartzManagerService");
        quartzManagerService.removeJob(grouponNo,Constants.MarketingGroupon.JOB_GROUP_MEMBER_MSG,grouponNo,Constants.MarketingGroupon.JOB_GROUP_MEMBER_MSG);
        TaskJob taskJob = new TaskJob();
        taskJob.setId(jobId);
        taskJob.setState(SchedulingJob.JS_DELETE);
        taskJob.setEndTime(DateUtil.now());
        TaskJobService taskJobService  =  (TaskJobService)ApplicationContextHelper.getBean("taskJobService");
        taskJobService.updateTaskJob(taskJob);
    }


}
