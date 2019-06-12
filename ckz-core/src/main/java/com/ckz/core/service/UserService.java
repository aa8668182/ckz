package com.ckz.core.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ckz.core.common.ApiResponse;
import com.ckz.core.domain.base.PageBaseResp;
import com.ckz.core.domain.request.UserListReq;
import com.ckz.core.domain.response.UserRegResp;
import com.ckz.core.entity.User;

/**
 * 用户表
 *
 * @author ckz
 * @email 不告诉你
 * @date 2019-02-18 16:32:06
 */
public interface UserService extends IService<User> {
    ApiResponse<PageBaseResp<UserRegResp>> getUserList(UserListReq req);
}