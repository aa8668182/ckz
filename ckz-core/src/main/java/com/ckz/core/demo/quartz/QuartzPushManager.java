package com.ckz.core.demo.quartz;

import com.ningpai.label.bean.NpLabelPush;
import com.ningpai.util.scheduler.SchedulerUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.quartz.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service("quartzPushManager")
public class QuartzPushManager {
    private static SchedulerFactory gSchedulerFactory = SchedulerUtil.getgSchedulerFactory();
    private static final String Group_Name = "Push_Trigger";

    public static String getGroup_Name() {
        return Group_Name;
    }

    //    TriggerUtils.

    /**
     * 系统初始化的时候，启动所有的标签推送
     * @param list
     */
    public void startUpSys( List<NpLabelPush> list) throws SchedulerException {
        if(Objects.isNull(list) || list.isEmpty()){
            return;
        }
        for(NpLabelPush vo:list){
            String jobName = vo.getPush_name();
            if(StringUtils.isNotBlank(jobName)){
                startOnePush(vo);//启动一个标签推送
            }
        }
    }

    /**
     * 启动一个标签推送定时任务
     * @param vo
     */
    public boolean startOnePush(NpLabelPush vo) throws SchedulerException {
        Scheduler scheduler = gSchedulerFactory.getScheduler();
        SimpleTrigger trigger = (SimpleTrigger) scheduler.getTrigger(vo.getPush_name(), Group_Name);
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("pushId", vo.getPush_id());
        jobDataMap.put("jobName", vo.getPush_name());
        try{
            if(Objects.isNull(trigger)){// 如果不存在该trigger则创建一个
                JobDetail jobDetail = new JobDetail(vo.getPush_name(),Group_Name,PushWeixinMsgJob.class);
                jobDetail.setJobDataMap(jobDataMap);
                trigger = new SimpleTrigger(vo.getPush_name(),Group_Name,vo.getPush_time());
//                trigger = new SimpleTrigger(vo.getPush_name(),Group_Name,new Date(System.currentTimeMillis()+1000*10)); for test
//            schedular.rescheduleJob(trigger.getName(), trigger.getGroup(), trigger);
                scheduler.scheduleJob(jobDetail,trigger);
            }else{// Trigger已存在，那么更新相应的定时设置
                trigger.setStartTime(vo.getPush_time());
                scheduler.rescheduleJob(trigger.getName(), trigger.getGroup(), trigger);
            }
            // 启动
            if (!scheduler.isShutdown()) {
                scheduler.start();
            }
        }catch(SchedulerException se){
            log.error("启动一个标签推送出错:",se);
            return false;
        }
        return true;
    }

    /**
     * 移除一个标签推送定时任务
     * @param jobName
     */
    public  void removeJob(String jobName){
        try {
            Scheduler sched = gSchedulerFactory.getScheduler();
            sched.pauseTrigger(jobName, Group_Name);// 停止触发器
            sched.unscheduleJob(jobName, Group_Name);// 移除触发器
            sched.deleteJob(jobName, Group_Name);// 删除任务
        } catch (SchedulerException e) {
            log.error("关闭一个标签推送出错:",e);
        }
    }
}
