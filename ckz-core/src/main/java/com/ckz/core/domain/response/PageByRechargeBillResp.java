package com.ckz.core.domain.response;

import com.ckz.core.domain.base.PageBaseResp;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: caikaizhen
 * @date: 2019/2/25 21:23
 * @Description:
 */
@ApiModel(value="PageByRechargeBillResp",description="渠道-充值账单分页对象")
@Data
public class PageByRechargeBillResp<T> extends PageBaseResp<T> {

    @ApiModelProperty(value="累计充值人民币",example="200.00")
    private BigDecimal totalMoney;

    @ApiModelProperty(value="累计购买泡泡币数",example="20000.00")
    private BigDecimal totalBubble;


    public PageByRechargeBillResp(PageInfo info) {
        super(info);
    }

    public PageByRechargeBillResp(Page info) {
        super(info);
    }
}
