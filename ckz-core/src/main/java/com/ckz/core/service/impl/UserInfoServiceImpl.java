package com.ckz.core.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ckz.core.entity.UserInfo;
import com.ckz.core.mapper.UserInfoMapper;
import com.ckz.core.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


/**
 * 用户详情表
 *
 * @author ckz
 * @email 不告诉你
 * @date 2019-02-18 16:31:34
 */
@Service
@Slf4j
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {
}