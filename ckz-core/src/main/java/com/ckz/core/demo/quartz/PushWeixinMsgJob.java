package com.ckz.core.demo.quartz;

import com.ningpai.common.util.ApplicationContextHelper;
import com.ningpai.label.service.LabelPushService;
import lombok.extern.log4j.Log4j;
import org.apache.commons.lang.StringUtils;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * 推送标签信息的定时任务
 */
@Log4j
@Component
public class PushWeixinMsgJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("PushWeixinMsgJob.....");
        JobDataMap dataMap = jobExecutionContext.getMergedJobDataMap();
        Long pushId = dataMap.getLong("pushId");
        String jobName =  dataMap.getString("jobName");
        log.info("pushId:"+pushId+",jobName"+jobName);
        if(Objects.isNull(pushId) || StringUtils.isBlank(jobName)){
            log.error("label push error ,pushid or jobName is null,pushId:"+pushId+",jobName:"+jobName);
            return;
        }
        sendMsg(pushId);
       try{
           remove(jobName,pushId);
       }catch(Exception e){
           log.error("remove a push job:",e);
       }
    }


    void sendMsg(Long pushId){
        LabelPushService labelPushService = (LabelPushService)ApplicationContextHelper.getBean("labelPushService");
        labelPushService.sendMsg(pushId);
    }

    /**
     * 删除或重试，具体策略可以自定义
     */
    void remove(String jobName,Long pushId){
        QuartzPushManager manager = (QuartzPushManager) ApplicationContextHelper.getBean("quartzPushManager");
        manager.removeJob(jobName);
        LabelPushService labelPushService = (LabelPushService)ApplicationContextHelper.getBean("labelPushService");
        labelPushService.stopPush(pushId);
    }
}
