package com.ckz.core.demo.aliemas.service.impl;

import com.aliyuncs.exceptions.ClientException;
import com.ningpai.aliemas.bean.AppDevice;
import com.ningpai.aliemas.bean.AppDeviceExample;
import com.ningpai.aliemas.dao.AppDeviceMapper;
import com.ningpai.aliemas.service.AppDeviceService;
import com.ningpai.aliemas.utils.AppPushClient;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service("AppDeviceService")
@Log4j
public class AppDeviceServiceImpl implements AppDeviceService {

    @Autowired
    private AppDeviceMapper appDeviceMapper;

    @Autowired
    private AppPushClient appPushClient;

    @Override
    public void sendAppMsg(Long customerId, String title, String body) {
        if(Objects.isNull(customerId)){
            return;
        }
//        AppDevice device = appDeviceMapper.selectByUserId(customerId);
        AppDeviceExample example = new AppDeviceExample();
        example.createCriteria().andCustomeridEqualTo(customerId);
        List<AppDevice> devices = appDeviceMapper.selectByExample(example);
        if(Objects.isNull(devices) || devices.size()==0){
            log.error("找不到设备id，用户为："+customerId);
            return;
        }
        Map<String,Object> extraMsg = new HashMap<>();
        extraMsg.put("msgType","normal");
        devices.forEach(device->{
        try {
                appPushClient.pushMessage(device.getDeviceid(),device.getType(),title,body,"","",extraMsg);
            } catch (ClientException e) {
                appDeviceMapper.deleteByPrimaryKey(device.getId());
                log.error("移动推送消息失败："+customerId+","+e.getMessage());
            }
        });
    }

    @Override
    public void logOut(List<AppDevice> logOutDevices) {
        if(Objects.isNull(logOutDevices) || logOutDevices.size()==0){
            return;
        }
        String title = "异地上线通知";
        String body = "您的账号已经在其他设备登录";
        Map<String,Object> extraMsg = new HashMap<>();
        extraMsg.put("msgType","logout");
        logOutDevices.forEach(device->{
            try {
                appPushClient.pushMessage(device.getDeviceid(),device.getType(),title,body,"","",extraMsg);
            } catch (ClientException e) {
                appDeviceMapper.deleteByPrimaryKey(device.getId());
                log.error("移动推送消息失败："+device.getCustomerid()+","+e.getMessage());
            }
            appDeviceMapper.deleteByPrimaryKey(device.getId());
        });
    }
}
