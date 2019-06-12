package com.ckz.core.domain.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @author: caikaizhen
 * @date: 2019/2/20 13:17
 * @Description:
 */
@ApiModel(value="LiveChannelAccountReq",description="用户-登录")
@Data
public class LiveChannelAccountReq{

    @ApiModelProperty(value="登录账号", example = "15167697457" ,required = true)
    @NotBlank(message = "登录账号不能为空")
    @Pattern(regexp = "(0?(13|15|17|18|14)[0-9]{9})|()",message="登录账号必须为手机号")
    private String loginAccount;

    @ApiModelProperty(value="密码", example = "asd111", required = true)
    @NotBlank(message = "登录密码不能为空")
    @Pattern(regexp = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,12}$",message = "登录密码格式不正确,必须为6-12位英文加数字")
    private String password;

}
