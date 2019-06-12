package com.qianmi.marketing.groupon.quartz;

import com.ningpai.common.util.DateUtil;
import com.qianmi.common.Constants;
import com.qianmi.marketing.groupon.bean.TaskJob;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 任务管理类
 */
@Slf4j
@Service
public class QuartzManagerService {

    private static SchedulerFactory gSchedulerFactory = new StdSchedulerFactory();


    /**
     *重启系统是否需要重启定时器 restart
     * @param list
     */
    public void startUpCronSchedule(List<TaskJob> list,String restart) {
        if (list !=null && list.size() >0){
            SchedulingJob job = null ;
            JobDataMap paramsMap = null;
            Date afterDate = null;
            for(TaskJob task : list){
                 job = new SchedulingJob();
                job.setJobName(task.getBizId());
                Date date = DateUtil.now();
                if (date.after(task.getStartTime())&& Constants.YES_STRING.equals(restart)){
                    afterDate = new Date(date .getTime() + 120000);
                    job.setCronExpression(DateUtil.dateToString(afterDate,"ss mm HH dd")+DateUtil.dateToString(afterDate," MM ")+"? *");
                }else{
                    job.setCronExpression(task.getJobExpress());
                }
                job.setJobStartClass(task.getJobStartClass().trim());
                job.setJobGroup(Constants.MarketingGroupon.JOB_GROUP_NAME);
                paramsMap = new JobDataMap();
                paramsMap.put("bizId", task.getBizId());
                paramsMap.put("jobId",task.getId());
                startUpCronSchedule(job, paramsMap);
                log.info("系统结束初始化任务："+task.getId()+":"+task.getBizId());
            }
        }
    }


    /**
     * 自定义
     * @param schedulingJob
     * @param paramsMap
     * @return
     */
    public boolean startUpCronSchedule(SchedulingJob schedulingJob, JobDataMap paramsMap) {
        if (schedulingJob == null) {
            return false;
        }
        try {
            Scheduler scheduler = gSchedulerFactory.getScheduler();
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(schedulingJob.getJobName(),
                    schedulingJob.getJobGroup());
            if (null == trigger) {// 如果不存在该trigger则创建一个
                JobDetail jobDetail = new JobDetail(schedulingJob.getJobName(), schedulingJob.getJobGroup(),Class.forName(schedulingJob.getJobStartClass()));// 任务名，任务组，任务执行类
                jobDetail.setJobDataMap(paramsMap);
                // 触发器
                trigger = new CronTrigger(schedulingJob.getJobName(), schedulingJob.getJobGroup());// 触发器名,触发器组
                trigger.setCronExpression(schedulingJob.getCronExpression());// 触发器时间设定
                scheduler.scheduleJob(jobDetail, trigger);
            } else {
                // Trigger已存在，那么更新相应的定时设置
                trigger.setCronExpression(schedulingJob.getCronExpression());
                scheduler.rescheduleJob(trigger.getName(), trigger.getGroup(), trigger);
            }
            // 启动
            if (!scheduler.isShutdown()) {
                scheduler.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    /**
     *
     * @param taskJob
     * @param bizId
     * @param endTime
     * @return
     */
    public Boolean addTaskToSchedule(TaskJob taskJob,String bizId, Date endTime){
        SchedulingJob job = new SchedulingJob();
        job.setJobName(bizId);
        job.setCronExpression(DateUtil.dateToString(endTime,"ss mm HH dd")+DateUtil.dateToString(endTime," MM")+" ? *");
        job.setJobStartClass(taskJob.getJobStartClass());
        job.setJobGroup(taskJob.getJobGroup());
        JobDataMap paramsMap = new JobDataMap();
        paramsMap.put("bizId", bizId);
        paramsMap.put("jobId", taskJob.getId());
        return startUpCronSchedule(job, paramsMap);
    }

    /**
     * @Description: 修改一个任务的触发时间
     *
     * @param triggerName
     * @param triggerGroupName
     * @param time
     */
    public  void modifyJobTime(String triggerName,
                                     String triggerGroupName, String time) {
        try {
            Scheduler sched = gSchedulerFactory.getScheduler();
            CronTrigger trigger = (CronTrigger) sched.getTrigger(triggerName,triggerGroupName);
            if (trigger == null) {
                return;
            }
            String oldTime = trigger.getCronExpression();
            if (!oldTime.equalsIgnoreCase(time)) {
                CronTrigger ct = (CronTrigger) trigger;
                // 修改时间
                ct.setCronExpression(time);
                // 重启触发器
                sched.resumeTrigger(triggerName, triggerGroupName);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @Description: 移除一个任务
     *
     * @param jobName
     * @param jobGroupName
     * @param triggerName
     * @param triggerGroupName
     */
    public  void removeJob(String jobName, String jobGroupName,
                                 String triggerName, String triggerGroupName) {
        try {
            Scheduler sched = gSchedulerFactory.getScheduler();
            sched.pauseTrigger(triggerName, triggerGroupName);// 停止触发器
            sched.unscheduleJob(triggerName, triggerGroupName);// 移除触发器
            sched.deleteJob(jobName, jobGroupName);// 删除任务
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
