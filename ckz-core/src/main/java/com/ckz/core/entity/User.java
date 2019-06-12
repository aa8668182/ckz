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
 * 用户表
 * 
 * @author ckz
 * @email 不告诉你
 * @date 2019-02-18 16:32:06
 */
@TableName("mp_user")
@Data
@ApiModel(value="User",description="用户表")
public class User extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	    //用户id，主键自增
    @TableId
    @ApiModelProperty(value="用户id，主键自增")
    private Long id;
	
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
	
	    //创建人
    @TableField("creater")
    @ApiModelProperty(value="创建人")
    private String creater;
	
	    //修改人
    @TableField("modifier")
    @ApiModelProperty(value="修改人")
    private String modifier;
	
	    //用户名
    @TableField("username")
    @ApiModelProperty(value="用户名")
    private String username;
	
	    //密码
    @TableField("password")
    @ApiModelProperty(value="密码")
    private String password;
	
	    //手机号
    @TableField("phone")
    @ApiModelProperty(value="手机号")
    private String phone;
	
	    //性别 0男 1女  3未知
    @TableField("sex")
    @ApiModelProperty(value="性别 0男 1女  3未知")
    private Integer sex;
	
	    //昵称
    @TableField("nick")
    @ApiModelProperty(value="昵称")
    private String nick;
	
	    //出生年月日，格式yyyy-MM-dd
    @TableField("birthday")
    @ApiModelProperty(value="出生年月日，格式yyyy-MM-dd")
    private String birthday;
	
	    // 冒泡ID （随机生成一个八位数）
    @TableField("mp_label")
    @ApiModelProperty(value=" 冒泡ID （随机生成一个八位数）")
    private String mpLabel;
	
	    //高德地图云存储id
    @TableField("amap_id")
    @ApiModelProperty(value="高德地图云存储id")
    private Long amapId;
	
	    //对接融云token
    @TableField("token")
    @ApiModelProperty(value="对接融云token")
    private String token;
	
	    //用户随机uuid
    @TableField("uuid")
    @ApiModelProperty(value="用户随机uuid")
    private String uuid;
	
	    //用户类型 0普通用户 1虚拟用户 2官方账号 3冒泡小助手 4 达人认证 5即是虚拟用户又是达人 6直播间虚拟用户 7 派单室主持人 8 公开课导师 9 代售泡泡币代理 10 求生活动注册用户 11 游客用户信息 12 直播官方账号  13 运营人员  14 巡管人员
    @TableField("user_type")
    @ApiModelProperty(value="用户类型 0普通用户 1虚拟用户 2官方账号 3冒泡小助手 4 达人认证 5即是虚拟用户又是达人 6直播间虚拟用户 7 派单室主持人 8 公开课导师 9 代售泡泡币代理 10 求生活动注册用户 11 游客用户信息 12 直播官方账号  13 运营人员  14 巡管人员")
    private Integer userType;
	
	    //设备类型  a安卓  i IOS
    @TableField("net_type")
    @ApiModelProperty(value="设备类型  a安卓  i IOS")
    private String netType;
	
	    //APP版本号
    @TableField("app_version")
    @ApiModelProperty(value="APP版本号")
    private String appVersion;
	
	    //下载渠道
    @TableField("down_channel")
    @ApiModelProperty(value="下载渠道")
    private String downChannel;
	
	    //设备号
    @TableField("equip_num")
    @ApiModelProperty(value="设备号")
    private String equipNum;
	
	    //渠道id
    @TableField("channel_id")
    @ApiModelProperty(value="渠道id")
    private Long channelId;
	
	    //ios设备
    @TableField("idfa")
    @ApiModelProperty(value="ios设备")
    private String idfa;
	
	    //注册ip
    @TableField("ip")
    @ApiModelProperty(value="注册ip")
    private String ip;
	
	    //家族拉新
    @TableField("pull_family_id")
    @ApiModelProperty(value="家族拉新")
    private Long pullFamilyId;
	
	    //app包渠道  0冒泡 1阿拉show
    @TableField("app_id")
    @ApiModelProperty(value="app包渠道  0冒泡 1阿拉show")
    private Integer appId;
	
}
