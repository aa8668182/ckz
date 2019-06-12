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
 * @date 2019/2/22 18:02
 */
@ApiModel(value="UserRegResp",description="用户-渠道注册信息")
@Data
public class UserRegResp {

    @ApiModelProperty(value="用户昵称",example="张三")
    private String nick;

    @ApiModelProperty(value="冒泡ID",example="895264575")
    private String mpLabel;

    @ApiModelProperty(value="用户手机号",example="13344455555")
    private String phone;

    @ApiModelProperty(value="用户头像",example="hangzhou.aliyuncs.com/345234")
    private String photo;

    @ApiModelProperty(value="用户性别",example="1")
    private Integer sex;

    @ApiModelProperty(value="用户年龄",example="22")
    private String age;

    @ApiModelProperty(value="用户创建时间",example="2018-04-26 19:28:30")
    private String createTime;

}
