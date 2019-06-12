package com.ckz.core.demo.aliemas.service;

import com.ningpai.aliemas.bean.AppDevice;

import java.util.List;

public interface AppDeviceService {

    void sendAppMsg(Long customerId, String title, String body);

    void logOut(List<AppDevice> logOutDevices);
}
