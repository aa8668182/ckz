package com.ckz.core.demo.quartz;

import com.ningpai.label.bean.NpLabelPush;
import com.ningpai.label.service.LabelPushService;
import lombok.extern.log4j.Log4j;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 系统启动时运行,标签推送
 */
@Log4j
@Component
public class JobStartManager implements InitializingBean {

    @Autowired
    private QuartzPushManager quartzPushManager;

    @Autowired
    private LabelPushService labelPushService;

    @Override
    public void afterPropertiesSet() throws Exception {
        List<NpLabelPush> list  = labelPushService.listAllToPush();
        try{
            quartzPushManager.startUpSys(list);
        }catch(SchedulerException se){
            log.error("系统启动时运行，启动标签推送报错：",se);
        }
    }
}
