package com.ckz.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ckz.core.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户详情表
 * 
 * @author ckz
 * @email 不告诉你
 * @date 2019-02-18 16:31:34
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {
	
}
