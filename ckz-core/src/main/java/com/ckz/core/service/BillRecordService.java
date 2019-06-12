package com.ckz.core.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ckz.core.common.ApiResponse;
import com.ckz.core.domain.request.BillListReq;
import com.ckz.core.domain.response.PageByRechargeBillResp;
import com.ckz.core.domain.response.RechargeListResp;
import com.ckz.core.entity.BillRecord;

/**
 * 用户账单记录表
 *
 * @author ckz
 * @email 不告诉你
 * @date 2019-02-18 16:32:19
 */
public interface BillRecordService extends IService<BillRecord> {
    ApiResponse<PageByRechargeBillResp<RechargeListResp>> getBillList(BillListReq req);
}