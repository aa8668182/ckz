package com.ckz.core.demo.aliemas.dao;


import com.ningpai.aliemas.bean.AppDevice;
import com.ningpai.aliemas.bean.AppDeviceExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppDeviceMapper {
    long countByExample(AppDeviceExample example);

    int deleteByExample(AppDeviceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AppDevice record);

    int insertSelective(AppDevice record);

    List<AppDevice> selectByExample(AppDeviceExample example);

    AppDevice selectByPrimaryKey(Long id);

    AppDevice selectByUserId(Long customerId);

    int updateByExampleSelective(@Param("record") AppDevice record, @Param("example") AppDeviceExample example);

    int updateByExample(@Param("record") AppDevice record, @Param("example") AppDeviceExample example);

    int updateByPrimaryKeySelective(AppDevice record);

    int updateByPrimaryKey(AppDevice record);
}