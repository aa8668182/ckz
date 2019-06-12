package com.ckz.core.controller;


import com.ckz.core.common.ApiResponse;
import com.ckz.core.common.BaseController;
import com.ckz.core.domain.request.BillListReq;
import com.ckz.core.domain.response.PageByRechargeBillResp;
import com.ckz.core.domain.response.RechargeListResp;
import com.ckz.core.entity.BillRecord;
import com.ckz.core.service.BillRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * 用户账单记录表
 *
 * @author ckz
 * @email 不告诉你
 * @date 2019-02-18 16:32:19
 */
@RestController
@RequestMapping(value="billRecord", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
@Slf4j
@Api(value="账单",tags = "账单相关")
public class BillRecordController extends BaseController<BillRecordService, BillRecord> {

    @ApiOperation(value = "渠道充值查询")
    @RequestMapping(value = "/list")
    public ApiResponse<PageByRechargeBillResp<RechargeListResp>> getRechargeList(@RequestBody @Validated BillListReq req){
        return service.getBillList(req);
    }

}