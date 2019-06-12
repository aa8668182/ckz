package com.ckz.core.domain.request;

import com.ckz.core.domain.base.PageBaseReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zhurenjie
 * @version V1.0
 * @Title:
 * @Package com.live.channel.manager.domain.request
 * @Description:
 * @date 2019/2/25 11:52
 */
@ApiModel(value="BillListReq",description="账单-渠道充值查询")
@Data
public class BillListReq extends PageBaseReq {


    @ApiModelProperty(value="用户昵称或者冒泡ID或手机号", example = "13344445555")
    private String searchKey;

    @ApiModelProperty(value="开始时间", example = "2019-01-07 16:59:28")
    private String startDate;

    @ApiModelProperty(value="结束时间", example = "2019-02-07 16:59:28")
    private String endDate;
    private Long orderId;

}
