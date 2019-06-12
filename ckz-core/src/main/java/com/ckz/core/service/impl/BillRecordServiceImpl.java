package com.ckz.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ckz.core.common.ApiResponse;
import com.ckz.core.domain.request.BillListReq;
import com.ckz.core.domain.response.PageByRechargeBillResp;
import com.ckz.core.domain.response.RechargeListResp;
import com.ckz.core.domain.vo.MpBillRecordSumVo;
import com.ckz.core.entity.BillRecord;
import com.ckz.core.mapper.BillRecordMapper;
import com.ckz.core.mapper.MpBillRecordDoMapper;
import com.ckz.core.service.BillRecordService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.vdurmont.emoji.EmojiParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


/**
 * 用户账单记录表
 *
 * @author ckz
 * @email 不告诉你
 * @date 2019-02-18 16:32:19
 */
@Service
@Slf4j
public class BillRecordServiceImpl extends ServiceImpl<BillRecordMapper, BillRecord> implements BillRecordService {
    @Autowired
    MpBillRecordDoMapper mpBillRecordDoMapper;

    @Override
    public ApiResponse<PageByRechargeBillResp<RechargeListResp>> getBillList(BillListReq req) {
        MpBillRecordSumVo mpBillRecordSumVo = mpBillRecordDoMapper.selectRechargeListSum(req.getSearchKey(), req.getStartDate(), req.getEndDate(),req.getOrderId());
        PageHelper.startPage(req.getCurrentPage(), req.getPageSize());
        List<RechargeListResp> list = mpBillRecordDoMapper.selectRechargeList(req.getSearchKey(), req.getStartDate(), req.getEndDate(),req.getOrderId());

        Optional.ofNullable(list).ifPresent(p->p.stream().forEach(rechargeListRes -> {
            rechargeListRes.setNick(EmojiParser.parseToUnicode(rechargeListRes.getNick()));
        }));

        PageByRechargeBillResp<RechargeListResp> pageByRechargeBillResp = new PageByRechargeBillResp<>(new PageInfo<>(list));
        if (mpBillRecordSumVo != null) {
            pageByRechargeBillResp.setTotalMoney(mpBillRecordSumVo.getMoney());
            pageByRechargeBillResp.setTotalBubble(mpBillRecordSumVo.getBubble());
        } else {
            pageByRechargeBillResp.setTotalMoney(BigDecimal.ZERO);
            pageByRechargeBillResp.setTotalBubble(BigDecimal.ZERO);
        }
        return new ApiResponse().setOk(pageByRechargeBillResp);
    }
}