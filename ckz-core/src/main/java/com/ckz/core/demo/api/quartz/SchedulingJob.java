package com.qianmi.marketing.groupon.quartz;

import lombok.Data;

/**
 * 定时任务基础类
 * Created by wg on 2017/5/31.
 */
@Data
public class SchedulingJob {

    public static final int JS_ENABLED = 0; // 任务启用状态
    public static final int JS_DISABLED = 1; // 任务禁用状态
    public static final int JS_DELETE = 2; // 任务已删除状态

    private String jobName; // 任务的描述
    private String jobGroup; // 任务所属组的名称
    private int jobStatus; // 任务的状态，0：启用；1：禁用；2：已删除
    private String cronExpression; // 定时任务运行时间表达式
    private String memos; // 任务描述
    private String jobStartClass;//执行类
}
