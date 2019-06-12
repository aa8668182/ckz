package com.ckz.core.mapper;


import com.ckz.core.domain.response.RechargeListResp;
import com.ckz.core.domain.vo.MpBillRecordSumVo;
import com.ckz.core.entity.MpBillRecordDo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MpBillRecordDoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MpBillRecordDo record);

    int insertSelective(MpBillRecordDo record);

    MpBillRecordDo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MpBillRecordDo record);

    int updateByPrimaryKey(MpBillRecordDo record);

    /**
     * 充值查询
     * @param searchKey
     * @param startDate
     * @param endDate
     * @return
     */
    List<RechargeListResp> selectRechargeList(@Param("searchKey") String searchKey, @Param("startDate") String startDate, @Param("endDate") String endDate, @Param("orderId") Long orderId);

    /**
     * 充值求和
     * @param searchKey
     * @param startDate
     * @param endDate
     * @return
     */
    MpBillRecordSumVo selectRechargeListSum(@Param("searchKey") String searchKey, @Param("startDate") String startDate, @Param("endDate") String endDate, @Param("orderId") Long orderId);
}