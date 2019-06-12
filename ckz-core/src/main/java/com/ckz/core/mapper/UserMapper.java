package com.ckz.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ckz.core.entity.MpUserDo;
import com.ckz.core.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户表
 * 
 * @author ckz
 * @email 不告诉你
 * @date 2019-02-18 16:32:06
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    List<MpUserDo> selectByAppId(@Param("userKey") String userKey, @Param("startDate") String startDate, @Param("endDate") String endDate);
}
