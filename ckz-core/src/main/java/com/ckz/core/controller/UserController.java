package com.ckz.core.controller;


import com.ckz.core.common.ApiResponse;
import com.ckz.core.common.BaseController;
import com.ckz.core.domain.base.PageBaseResp;
import com.ckz.core.domain.request.UserListReq;
import com.ckz.core.domain.response.UserRegResp;
import com.ckz.core.entity.User;
import com.ckz.core.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 用户表
 *
 * @author ckz
 * @email 不告诉你
 * @date 2019-02-18 16:32:06
 */
@RestController
@RequestMapping(value="users" ,method = RequestMethod.POST)
@Slf4j
@Api(description = "用户",tags = "渠道用户相关")
public class UserController extends BaseController<UserService, User> {

    @ApiOperation(value = "注册用户信息查询")
    @RequestMapping(value = "/list")
    public ApiResponse<PageBaseResp<UserRegResp>> getUserList(@RequestBody @Validated UserListReq req){
        return service.getUserList(req);
    }

    public static void main(String[] args) {
        String min = "2019-05-20 08:34:51 Etc/GMT";
        String max = "2019-09-21 07:43:49 Etc/GMT";
        String max1 = "2019-08-22 07:41:49 Etc/GMT";
        String max2 = "2019-05-23 07:43:49 Etc/GMT";
        String max3 = "2019-06-24 07:44:49 Etc/GMT";

        List<String> array = new ArrayList<>();
        array.add(min);
        array.add(max);
        array.add(max1);
        array.add(max2);
        array.add(max3);

        array.sort((o1,o2)->{
            return o2.compareTo(o1);
        });


        array.forEach(System.out::println);

    }
}