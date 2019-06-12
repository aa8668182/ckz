package com.ckz.core.mapper;

import com.ckz.core.entity.MpMonthBillRecordDo;

public interface MpMonthBillRecordDoMapper {

    int insertSelective(MpMonthBillRecordDo record);

    int updateByPrimaryKeySelective(MpMonthBillRecordDo record);

}