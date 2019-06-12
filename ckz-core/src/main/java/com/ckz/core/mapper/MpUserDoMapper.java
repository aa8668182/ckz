package com.ckz.core.mapper;


import com.ckz.core.domain.response.UserRegResp;
import com.ckz.core.entity.MpUserDo;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface MpUserDoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MpUserDo record);

    int insertSelective(MpUserDo record);

    MpUserDo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MpUserDo record);

    int updateByPrimaryKey(MpUserDo record);

    List<UserRegResp> selectByAppId(@Param("userKey") String userKey, @Param("startDate") String startDate, @Param("endDate") String endDate);
}