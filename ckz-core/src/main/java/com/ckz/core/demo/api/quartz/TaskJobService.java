package com.qianmi.marketing.groupon.quartz;

import com.ningpai.common.util.DateUtil;
import com.ningpai.datarouter.DataRouter;
import com.ningpai.datarouter.DataRouterCommon;
import com.qianmi.common.Constants;
import com.qianmi.marketing.groupon.bean.TaskJob;
import com.qianmi.marketing.groupon.dao.TaskJobMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * 定时任务接口
 *  Created By wg on 2017/5/31
 */
@Service
public class TaskJobService {

    @Resource
    private TaskJobMapper taskJobMapper;


    @Resource
    private QuartzManagerService quartzManagerService;

    /**
     * 新增任务
     * @param taskJob
     * @return
     */
    @Transactional
    public Integer addTaskJob(TaskJob taskJob){
        return taskJobMapper.addTaskJob(taskJob);
    }

    /**
     * 获取所有的定时任务
     * @param taskJob
     * @return
     */
    @DataRouter(DataRouterCommon.NO_CC)
    public List<TaskJob> queryAllTaskJob(TaskJob taskJob){
        return  taskJobMapper.queryAllTaskJob(taskJob);
//        return Collections.emptyList();
    }

    /**
     * 更新任务
     * @param taskJob
     * @return
     */
    @Transactional
    @DataRouter(DataRouterCommon.NO_CC)
    public Integer updateTaskJob(TaskJob taskJob){
        return taskJobMapper.updateTaskJob(taskJob);
    }

    /**
     * 根据ID查询任务信息
     * @param id
     * @return
     */
    public TaskJob queryTaskJobById(Long id){return taskJobMapper.queryTaskJobById(id);}


    /**
     * 新增定时任务
     * @param bizId 业务ID(例如：拼团业务时，为团编号)
     * @param endTime 定时任务启动时间
     * @return
     */
    public Integer addTaskJob(String bizId, Date endTime){
        //新增一个开团任务
        TaskJob taskJob = new TaskJob();
        taskJob.setAutoRun(1);
        taskJob.setBizId(bizId);
        taskJob.setStartTime(endTime);
        taskJob.setBizType("拼团");
        taskJob.setJobStartClass("com.qianmi.marketing.groupon.quartz.GrouponQuartzJob");
        taskJob.setJobGroup(Constants.MarketingGroupon.JOB_GROUP_NAME);
//        taskJob.setJobExpress(DateUtil.dateToString(endTime,"ss mm HH dd")+DateUtil.dateToString(endTime," MM")+" ? *");
        taskJob.setJobExpress(DateUtil.dateToString(endTime,"ss mm HH")+" * * ? *");
        taskJob.setState(0);
        taskJob.setInfo(bizId+"拼团订单定时任务开启");
        int result = addTaskJob(taskJob);
        if (result>0){
            return taskJob.getId();
        }
        return  0;
    }


    /**
     * 新增参团人数不足定时任务
     * @param bizId 业务ID(例如：拼团业务时，为团编号)
     * @param endTime 定时任务启动时间
     * @return
     */
    public Integer addMemberMsgTaskJob(String bizId, Date endTime){
        //新增一个开团任务
        TaskJob taskJob = new TaskJob();
        taskJob.setAutoRun(1);
        taskJob.setBizId(bizId);
        taskJob.setStartTime(endTime);
        taskJob.setBizType("拼团参团人数不足提醒");
        taskJob.setJobStartClass("com.qianmi.marketing.groupon.quartz.GrouponMemberMsgQuartzJob");
        taskJob.setJobGroup(Constants.MarketingGroupon.JOB_GROUP_MEMBER_MSG);
//        taskJob.setJobExpress(DateUtil.dateToString(endTime,"ss mm HH dd")+DateUtil.dateToString(endTime," MM")+" ? *");
        taskJob.setJobExpress(DateUtil.dateToString(endTime,"ss mm HH")+" * * ? *");
        taskJob.setState(0);
        taskJob.setInfo(bizId+"拼团参团人数不足提醒定时任务开启");
        int result = addTaskJob(taskJob);
        if (result>0){
            return taskJob.getId();
        }
        return  0;
    }
}
