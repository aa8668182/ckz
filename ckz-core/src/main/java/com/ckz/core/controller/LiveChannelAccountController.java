package com.ckz.core.controller;


import com.ckz.core.annotation.IgnoreUserToken;
import com.ckz.core.common.ApiResponse;
import com.ckz.core.common.BaseController;
import com.ckz.core.common.MpExceptionCode;
import com.ckz.core.domain.request.LiveChannelAccountReq;
import com.ckz.core.domain.request.RestPasswordReq;
import com.ckz.core.domain.response.CurrentLoginUserInfoResp;
import com.ckz.core.entity.LiveChannelAccount;
import com.ckz.core.service.LiveChannelAccountService;
import com.ckz.core.utils.BaseContextHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

/**
 * 
 *
 * @author ckz
 * @email 不告诉你
 * @date 2019-02-20 12:01:44
 */
@RestController
@RequestMapping(value="liveChannelAccount", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
@Slf4j
@Api(description = "运营后台用户",tags="运营后台用户相关")
public class LiveChannelAccountController extends BaseController<LiveChannelAccountService, LiveChannelAccount> {

    @ApiOperation(value = "登录")
    @RequestMapping("/login")
    @IgnoreUserToken
    public ApiResponse<String> login(@Validated @RequestBody LiveChannelAccountReq liveChannelAccountReq){
        try {
            ApiResponse<String> apiResponse=service.login(liveChannelAccountReq);
            return apiResponse;
        } catch (Exception e) {
           log.info("liveChannelAccount==>login:{}",e.toString());
        }
        return new ApiResponse().setMpExceptionCode(MpExceptionCode.NO_LOGIN);
    }


    @ApiOperation(value = "获取登录用户的信息")
    @RequestMapping("/loginInfo")
    public ApiResponse<CurrentLoginUserInfoResp> loginInfo(){
        //登录用户账号
        String loginAccount = BaseContextHandler.getLoginAccount();
        //登录用户昵称
        String loginName = BaseContextHandler.getLoginName();
        //登录用户渠道
        String appId = BaseContextHandler.getAppId();
        //登录用户ID
        String userId = BaseContextHandler.getUserID();
        CurrentLoginUserInfoResp currentLoginUserInfoResp = new CurrentLoginUserInfoResp(loginAccount,loginName,appId,userId);
        ApiResponse<CurrentLoginUserInfoResp> apiResponse = new ApiResponse().setMpExceptionCode(MpExceptionCode.SUCCESS);
        apiResponse.setData(currentLoginUserInfoResp);
        return apiResponse;
    }




    @ApiOperation(value = "修改密码")
    @RequestMapping("/restPassword")
    public ApiResponse<String> restPassword(@Validated @RequestBody RestPasswordReq restPasswordReq){
        try {
            return service.restPassword(restPasswordReq);
        } catch (Exception e) {
            log.info("liveChannelAccount==>restPassword:{}",e.toString());
        }
        return new ApiResponse().setMpExceptionCode(MpExceptionCode.FAILED);
    }



    @ApiOperation(value = "spring异步-测试方法")
    @RequestMapping("/asyncTest")
    @IgnoreUserToken
    public ApiResponse asyncTest() throws Exception {
        //future可以获取异步中的异常,会对程序产生影响
        Future<String> future = service.testAsync();

        //异步异常不会对程序产生影响
        service.testAsync2();

        log.info("begin to deal other Task!");
        while (true) {
            if(future.isCancelled()){
                log.info("deal async task is Cancelled");
                break;
            }
            if (future.isDone() ) {
                log.info("deal async task is Done");
                log.info("return result is " + future.get());//这里会抛出异常
                break;
            }
            log.info("wait async task to end ...");
            Thread.sleep(1000);
        }
        return new ApiResponse().setMpExceptionCode(MpExceptionCode.SUCCESS);
    }



}