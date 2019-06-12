package com.ckz.core.domain.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author zhurenjie
 * @version V1.0
 * @Title:
 * @Package com.live.channel.manager.entity
 * @Description:
 * @date 2019/2/25 16:06
 */
@Data
public class MpBillRecordSumVo {
    private BigDecimal bubble;
    private BigDecimal money;
    private BigDecimal soap;
}
