package com.ckz.core.domain.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @author: caikaizhen
 * @date: 2019/2/21 11:31
 * @Description:
 */
@Data
@ApiModel(value="RestPasswordReq",description="用户-修改密码")
public class RestPasswordReq {

    @ApiModelProperty(value="原始密码",example = "ckz111",required = true)
    @NotBlank(message = "原始密码不能为空")
    @Pattern(regexp = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,12}$",message = "原始密码格式不正确,必须为6-12位英文加数字")
    private String  oldPassword;

    @ApiModelProperty(value="新密码",example = "asd111",required = true)
    @NotBlank(message = "新密码不能为空")
    @Pattern(regexp = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,12}$",message = "新密码格式不正确,必须为6-12位英文加数字")
    private String  password;

}
