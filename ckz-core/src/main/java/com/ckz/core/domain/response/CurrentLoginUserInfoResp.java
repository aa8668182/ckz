package com.ckz.core.domain.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author: caikaizhen
 * @date: 2019/2/21 11:17
 * @Description:
 */
@ApiModel(value="CurrentLoginUserInfoResp",description="用户-信息")
@Data
@AllArgsConstructor
public class CurrentLoginUserInfoResp {

    //登录用户账号
    @ApiModelProperty(value="登录用户账号",example = "13351515151")
    private String loginAccount;
    //登录用户昵称
    @ApiModelProperty(value="登录用户昵称",example = "cc")
    private String loginName;
    //登录用户渠道
    @ApiModelProperty(value="登录用户渠道",example = "1")
    private String appId;
    //登录用户ID
    @ApiModelProperty(value="登录用户ID",example = "1")
    private String userId;
}
