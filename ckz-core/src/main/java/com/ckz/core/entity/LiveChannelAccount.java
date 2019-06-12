package com.ckz.core.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ckz.core.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


/**
 * 
 * 
 * @author ckz
 * @email 不告诉你
 * @date 2019-02-20 12:01:44
 */
@TableName("mp_live_channel_account")
@Data
@ApiModel(value="LiveChannelAccount",description="")
public class LiveChannelAccount extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	    //
    @TableId
    @ApiModelProperty(value="")
    private Integer id;
	
	    //是否删除状态，1：删除，0：有效
    @TableField("is_delete")
    @ApiModelProperty(value="是否删除状态，1：删除，0：有效")
    @TableLogic
    private Integer isDelete;
	
	    //创建时间
    @TableField("create_time")
    @ApiModelProperty(value="创建时间")
    private Date createTime;
	
	    //修改时间
    @TableField("modify_time")
    @ApiModelProperty(value="修改时间")
    private Date modifyTime;
	
	    //创建者
    @TableField("creater")
    @ApiModelProperty(value="创建者")
    private String creater;
	
	    //修改者
    @TableField("modify")
    @ApiModelProperty(value="修改者")
    private String modify;
	
	    //账号（使用电话）
    @TableField("login_account")
    @ApiModelProperty(value="账号（使用电话）")
    private String loginAccount;
	
	    //名称
    @TableField("login_name")
    @ApiModelProperty(value="名称")
    private String loginName;
	
	    //密码
    @TableField("password")
    @ApiModelProperty(value="密码")
    private String password;
	
	    //0 禁用 1 启用
    @TableField("status")
    @ApiModelProperty(value="0 禁用 1 启用")
    private Integer status;
	
	    //渠道ID
    @TableField("app_id")
    @ApiModelProperty(value="渠道ID")
    private Integer appId;
	
}
