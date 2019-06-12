package com.ckz.core.service;



import com.baomidou.mybatisplus.extension.service.IService;
import com.ckz.core.common.ApiResponse;
import com.ckz.core.domain.request.LiveChannelAccountReq;
import com.ckz.core.domain.request.RestPasswordReq;
import com.ckz.core.entity.LiveChannelAccount;

import java.util.concurrent.Future;

/**
 * 
 *
 * @author ckz
 * @email 不告诉你
 * @date 2019-02-20 12:01:44
 */
public interface LiveChannelAccountService extends IService<LiveChannelAccount> {
    /**
     * 运营后台登录
     * @param liveChannelAccountReq
     * @return
     */
    ApiResponse<String> login(LiveChannelAccountReq liveChannelAccountReq) throws Exception;

    ApiResponse<String> restPassword(RestPasswordReq restPasswordReq);

    Future<String> testAsync() throws InterruptedException;
    void testAsync2() throws InterruptedException;
}