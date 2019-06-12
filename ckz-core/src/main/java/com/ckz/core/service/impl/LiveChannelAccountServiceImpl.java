package com.ckz.core.service.impl;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ckz.core.common.ApiResponse;
import com.ckz.core.common.MpExceptionCode;
import com.ckz.core.config.JwtTokenUtil;
import com.ckz.core.domain.request.LiveChannelAccountReq;
import com.ckz.core.domain.request.RestPasswordReq;
import com.ckz.core.entity.LiveChannelAccount;
import com.ckz.core.mapper.LiveChannelAccountMapper;
import com.ckz.core.service.LiveChannelAccountService;
import com.ckz.core.utils.BaseContextHandler;
import com.ckz.core.utils.JWTInfo;
import com.ckz.core.utils.Md5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.concurrent.Future;


/**
 * 
 *
 * @author ckz
 * @email 不告诉你
 * @date 2019-02-20 12:01:44
 */
@Service
@Slf4j
public class LiveChannelAccountServiceImpl extends ServiceImpl<LiveChannelAccountMapper, LiveChannelAccount> implements LiveChannelAccountService {

    @Resource
    private JwtTokenUtil jwtTokenUtil;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ApiResponse<String> login(LiveChannelAccountReq liveChannelAccountReq) throws Exception {
        ApiResponse<String> apiResponse;
        String loginAccount = liveChannelAccountReq.getLoginAccount();
        Wrapper<LiveChannelAccount> condition = new QueryWrapper<LiveChannelAccount>().select("id" ,"login_account", "login_name","password","app_id").eq("login_account", loginAccount);
//        boolean exist = this.retBool(this.count(condition));
        LiveChannelAccount liveChannelAccount = baseMapper.selectOne(condition);
        if (this.retBool(liveChannelAccount.getId())) {
            //此处需要加密
            boolean equals = Md5Util.verify(liveChannelAccountReq.getPassword(), liveChannelAccount.getPassword());
//            boolean equals = liveChannelAccountReq.getPassword().equals(liveChannelAccount.getPassword());
            //生成jwttoken给前端
            if(equals){
                JWTInfo jwtInfo = new JWTInfo(liveChannelAccount.getLoginAccount(), liveChannelAccount.getId().toString(), liveChannelAccount.getLoginName(),liveChannelAccount.getAppId().toString());
                String token = jwtTokenUtil.generateToken(jwtInfo);
                log.info("token===>{}", token);
                apiResponse= new ApiResponse().setMpExceptionCode(MpExceptionCode.SUCCESS);
                apiResponse.setData(token);
                return apiResponse;
            }
            apiResponse= new ApiResponse().setMpExceptionCode(MpExceptionCode.LOGIN_ERROR_PASSWORD);
            return apiResponse;
        }else{
             apiResponse = new ApiResponse().setMpExceptionCode(MpExceptionCode.N0_USER);
            return apiResponse;
        }
    }

    @Override
    public ApiResponse<String> restPassword(RestPasswordReq restPasswordReq) {
        String userID = BaseContextHandler.getUserID();
        Wrapper<LiveChannelAccount> condition = new QueryWrapper<LiveChannelAccount>().select("id" ,"password").eq("id", userID);
        LiveChannelAccount liveChannelAccount = baseMapper.selectOne(condition);

//        if (liveChannelAccount.getPassword().equals(restPasswordReq.getOldPassword())) {
        if (Md5Util.verify(restPasswordReq.getOldPassword(), liveChannelAccount.getPassword())) {
            LiveChannelAccount updatePasswordEntity = new LiveChannelAccount();
            updatePasswordEntity.setId(Integer.valueOf(userID));
            //加密
            updatePasswordEntity.setPassword(Md5Util.generate(restPasswordReq.getPassword()));
           if(retBool(baseMapper.updateById(updatePasswordEntity))){
               return new ApiResponse().setMpExceptionCode(MpExceptionCode.SUCCESS);
           }else{
               return new ApiResponse().setMpExceptionCode(MpExceptionCode.FAILED);
           }
        }
        return new ApiResponse().setMpExceptionCode(MpExceptionCode.LOGIN_ERROR_PASSWORD);
    }

    public static void main(String[] args) {
        System.out.println(Md5Util.generate("asd111"));
    }




    @Async("IOThreadPool")
    public Future<String> testAsync() throws InterruptedException {
        System.out.println("=====" + Thread.currentThread().getName() + "=========");
        int i=1/0;
        Thread.sleep(10000);
        return new AsyncResult<String>("sss");
    }

    @Async("IOThreadPool")
    public void testAsync2() throws InterruptedException {
        System.out.println("=====" + Thread.currentThread().getName() + "=========");
        int i=1/0;
        Thread.sleep(10000);
    }
}