package com.ckz.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ckz.core.common.ApiResponse;
import com.ckz.core.domain.base.PageBaseResp;
import com.ckz.core.domain.request.UserListReq;
import com.ckz.core.domain.response.UserRegResp;
import com.ckz.core.entity.User;
import com.ckz.core.mapper.MpUserDoMapper;
import com.ckz.core.mapper.UserMapper;
import com.ckz.core.service.UserService;
import com.ckz.core.utils.DateUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vdurmont.emoji.EmojiParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


/**
 * 用户表
 *
 * @author ckz
 * @email 不告诉你
 * @date 2019-02-18 16:32:06
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    MpUserDoMapper mpUserDoMapper;

    @Override
    public ApiResponse<PageBaseResp<UserRegResp>> getUserList(UserListReq req) {
        PageHelper.startPage(req.getCurrentPage(),req.getPageSize());
        List<UserRegResp> list = mpUserDoMapper.selectByAppId(req.getUserKey(),req.getStartDate(),req.getEndDate());
        Optional.ofNullable(list).ifPresent(p -> p.stream().forEach(userRegRes -> {
            userRegRes.setNick(EmojiParser.parseToUnicode(userRegRes.getNick()));
            userRegRes.setAge(DateUtils.getAgeByBirth(userRegRes.getAge()).toString());
        }));
        PageBaseResp<UserRegResp> userRegResPageBaseResp = new PageBaseResp<>(new PageInfo<>(list));
        return new ApiResponse<PageBaseResp<UserRegResp>>().setOk(userRegResPageBaseResp);
    }
}