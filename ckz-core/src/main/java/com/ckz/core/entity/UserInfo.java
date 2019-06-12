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
 * 用户详情表
 * 
 * @author ckz
 * @email 不告诉你
 * @date 2019-02-18 16:31:34
 */
@TableName("mp_user_info")
@Data
@ApiModel(value="UserInfo",description="用户详情表")
public class UserInfo extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	    //主键自增
    @TableId
    @ApiModelProperty(value="主键自增")
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
	
	    //星座
    @TableField("constellation")
    @ApiModelProperty(value="星座")
    private String constellation;
	
	    //签名
    @TableField("autograph")
    @ApiModelProperty(value="签名")
    private String autograph;
	
	    //用户id
    @TableField("user_id")
    @ApiModelProperty(value="用户id")
    private Long userId;
	
	    //注册国家编码
    @TableField("country_code")
    @ApiModelProperty(value="注册国家编码")
    private String countryCode;
	
	    //注册国家
    @TableField("country_name")
    @ApiModelProperty(value="注册国家")
    private String countryName;
	
	    //注册城市编码
    @TableField("city_code")
    @ApiModelProperty(value="注册城市编码")
    private String cityCode;
	
	    //注册城市
    @TableField("city_name")
    @ApiModelProperty(value="注册城市")
    private String cityName;
	
	    //注册地区编码
    @TableField("area_code")
    @ApiModelProperty(value="注册地区编码")
    private String areaCode;
	
	    //注册地区名称
    @TableField("area_name")
    @ApiModelProperty(value="注册地区名称")
    private String areaName;
	
	    //注册具体地址
    @TableField("location")
    @ApiModelProperty(value="注册具体地址")
    private String location;
	
	    //经度
    @TableField("longitude")
    @ApiModelProperty(value="经度")
    private Double longitude;
	
	    //纬度
    @TableField("latitude")
    @ApiModelProperty(value="纬度")
    private Double latitude;
	
	    //身高
    @TableField("height")
    @ApiModelProperty(value="身高")
    private String height;
	
	    //体型
    @TableField("shape")
    @ApiModelProperty(value="体型")
    private String shape;
	
	    //血型
    @TableField("blood_type")
    @ApiModelProperty(value="血型")
    private String bloodType;
	
	    //
    @TableField("school_id")
    @ApiModelProperty(value="")
    private Long schoolId;
	
	    //学校
    @TableField("school")
    @ApiModelProperty(value="学校")
    private String school;
	
	    //性取向
    @TableField("sex_orientation")
    @ApiModelProperty(value="性取向")
    private String sexOrientation;
	
	    //情感状况
    @TableField("emotional_state")
    @ApiModelProperty(value="情感状况")
    private String emotionalState;
	
	    //
    @TableField("hometown_id")
    @ApiModelProperty(value="")
    private Long hometownId;
	
	    //家乡
    @TableField("hometown")
    @ApiModelProperty(value="家乡")
    private String hometown;
	
	    //废弃,头像
    @TableField("avatar")
    @ApiModelProperty(value="废弃,头像")
    private String avatar;
	
	    //废弃,弹弹封面照片
    @TableField("bomb_url")
    @ApiModelProperty(value="废弃,弹弹封面照片")
    private String bombUrl;
	
	    //是否支付宝认证 0否 1是
    @TableField("alipay_certified")
    @ApiModelProperty(value="是否支付宝认证 0否 1是")
    private Integer alipayCertified;
	
	    //微信认证  0否 1是
    @TableField("weChat_certified")
    @ApiModelProperty(value="微信认证  0否 1是")
    private Integer wechatCertified;
	
	    //支付宝账号
    @TableField("alipay_account")
    @ApiModelProperty(value="支付宝账号")
    private String alipayAccount;
	
	    //真实姓名
    @TableField("real_name")
    @ApiModelProperty(value="真实姓名")
    private String realName;
	
	    //支付宝认证凭证
    @TableField("authNo")
    @ApiModelProperty(value="支付宝认证凭证")
    private String authno;
	
	    //0:显示地理位置 1:不显示地理位置
    @TableField("user_geographic_privacy")
    @ApiModelProperty(value="0:显示地理位置 1:不显示地理位置")
    private Integer userGeographicPrivacy;
	
	    //省
    @TableField("province")
    @ApiModelProperty(value="省")
    private String province;
	
	    //市
    @TableField("city")
    @ApiModelProperty(value="市")
    private String city;
	
}
