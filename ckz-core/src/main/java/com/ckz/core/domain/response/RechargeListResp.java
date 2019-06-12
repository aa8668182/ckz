package com.ckz.core.domain.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zhurenjie
 * @version V1.0
 * @Title:
 * @Package com.live.channel.manager.domain.response
 * @Description:
 * @date 2019/2/25 14:16
 */
@ApiModel(value="RechargeListResp",description="渠道-充值账单")
@Data
public class RechargeListResp {

    @ApiModelProperty(value="用户冒泡ID",example = "808891319")
    private String mpLabel;

    @ApiModelProperty(value="用户昵称",example="张三")
    private String nick;

    @ApiModelProperty(value="用户手机号",example="13344455555")
    private String phone;

    @ApiModelProperty(value="订单ID",example="订单ID")
    private String orderId;

    @ApiModelProperty(value="订单创建时间",example="2018-02-04 20:54:01")
    private String createTime;

    @ApiModelProperty(value="人民币",example="1")
    private String money;

    @ApiModelProperty(value="泡泡币",example="100")
    private String bubble;
}
