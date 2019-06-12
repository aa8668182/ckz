package com.ckz.core.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ckz.core.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;


/**
 * 用户账单记录表
 * 
 * @author ckz
 * @email 不告诉你
 * @date 2019-02-18 16:32:19
 */
@TableName("mp_bill_record")
@Data
@ApiModel(value="BillRecord",description="用户账单记录表")
public class BillRecord extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	    //主键自增
    @TableId
    @ApiModelProperty(value="主键自增")
    private Long id;
	
	    // 是否删除状态，1：删除，0：有效
    @TableField("is_delete")
    @ApiModelProperty(value=" 是否删除状态，1：删除，0：有效")
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
	
	    //用户id
    @TableField("user_id")
    @ApiModelProperty(value="用户id")
    private Long userId;
	
	    //账单类型，0其他账单，1余额账单，2收益账单，3泡泡币账单，4 肥皂币账单 5家族肥皂币账单 6系统礼物账单,7现金账单
    @TableField("bill_type")
    @ApiModelProperty(value="账单类型，0其他账单，1余额账单，2收益账单，3泡泡币账单，4 肥皂币账单 5家族肥皂币账单 6系统礼物账单,7现金账单")
    private Integer billType;
	
	    //具体类型，-5直播活跃用户泡币奖励活动,-4活动发放至运营账户，-3自充值泡币转移，-2返点泡币，0其他，1余额充值，2余额活动奖励，3订单退款，4订单消费，5订单收入，6礼物兑换，7收益活动奖励，8收入提现，9泡泡币充值，10邀请好友得奖励，11任务奖励，12送礼打赏,13签到奖励，14邀请人成为达人得奖励，15后台充值泡泡币，16后台充值人民币 , 17豪车游戏充值, 18宝箱奖励,19豪车游戏提现，20 肥皂币兑换（肥皂币账单），21 打赏获得肥皂币，22 直播打赏泡泡币，23肥皂币兑换收益（收益账单），24弹幕消耗泡泡币,25订单结算扣除手续费,26后台充值肥皂币,27私人订制课程购买,28周星奖励肥皂币,29代理后台充值泡泡币,30奖池变化泡泡币,31中奖所得泡泡币，32私人订制购买退款, 33派单室打赏，34代理后台代充泡泡币 ,35兑换礼物收益(V3.5.1) 弃用,36打赏获得泡泡币,37购买主播特效,38运营后台扣款 ,39获得礼物收益(弃用),40求生活动登录奖励，41求生活动邀请奖励，42运营活动奖励,43主播整场肥皂收益记录，44主播在其他直播间的肥皂收益 45直播任务领取系统礼物 46打赏系统礼物，47主播被点歌获得肥皂币, 48消费返现 49点歌消耗泡泡币，50 pk宝箱,51赏金收益 52大客户充值 53主播弹幕获得肥皂币,54 月首充奖励泡币, 55 免审核兑换肥皂, 56 免审核兑换礼物 57.星冠活动中奖 58.网咖活动，59 免审核兑换肥皂(肥皂账单) 60.家族保证金 61.主播时补 62.当月流水补贴 63.主播底薪,65闪聊视频支付(弃用)，66闪聊语音支付(弃用)，67闪聊视频收益(弃用)，68闪聊语音收益(弃用),69直播打赏泡币系统礼物，70主播勋章结算获得肥皂币,71盛典活动抽奖 72 超能力达人活动奖励 73日历女神活动, 74：家族引流泡泡币充值,75：家族引流泡泡币返利,76：家族引流主播肥皂奖励；77:家族引流用戶打赏泡币 78双12活动购买礼包 79双12活动获得包裹礼物  80神灯节小程序用户兑换红包泡币奖励 81幸运转盘抽奖泡泡币消费 82 超级转盘抽奖泡泡币消费,83点亮神灯礼物 84 转盘抽奖奖励 85 神灯节任务奖励 86.支付宝转账 87.座驾购买（显示不下请加mp_bill_small_type)
    @TableField("small_type")
    @ApiModelProperty(value="具体类型，-5直播活跃用户泡币奖励活动,-4活动发放至运营账户，-3自充值泡币转移，-2返点泡币，0其他，1余额充值，2余额活动奖励，3订单退款，4订单消费，5订单收入，6礼物兑换，7收益活动奖励，8收入提现，9泡泡币充值，10邀请好友得奖励，11任务奖励，12送礼打赏,13签到奖励，14邀请人成为达人得奖励，15后台充值泡泡币，16后台充值人民币 , 17豪车游戏充值, 18宝箱奖励,19豪车游戏提现，20 肥皂币兑换（肥皂币账单），21 打赏获得肥皂币，22 直播打赏泡泡币，23肥皂币兑换收益（收益账单），24弹幕消耗泡泡币,25订单结算扣除手续费,26后台充值肥皂币,27私人订制课程购买,28周星奖励肥皂币,29代理后台充值泡泡币,30奖池变化泡泡币,31中奖所得泡泡币，32私人订制购买退款, 33派单室打赏，34代理后台代充泡泡币 ,35兑换礼物收益(V3.5.1) 弃用,36打赏获得泡泡币,37购买主播特效,38运营后台扣款 ,39获得礼物收益(弃用),40求生活动登录奖励，41求生活动邀请奖励，42运营活动奖励,43主播整场肥皂收益记录，44主播在其他直播间的肥皂收益 45直播任务领取系统礼物 46打赏系统礼物，47主播被点歌获得肥皂币, 48消费返现 49点歌消耗泡泡币，50 pk宝箱,51赏金收益 52大客户充值 53主播弹幕获得肥皂币,54 月首充奖励泡币, 55 免审核兑换肥皂, 56 免审核兑换礼物 57.星冠活动中奖 58.网咖活动，59 免审核兑换肥皂(肥皂账单) 60.家族保证金 61.主播时补 62.当月流水补贴 63.主播底薪,65闪聊视频支付(弃用)，66闪聊语音支付(弃用)，67闪聊视频收益(弃用)，68闪聊语音收益(弃用),69直播打赏泡币系统礼物，70主播勋章结算获得肥皂币,71盛典活动抽奖 72 超能力达人活动奖励 73日历女神活动, 74：家族引流泡泡币充值,75：家族引流泡泡币返利,76：家族引流主播肥皂奖励；77:家族引流用戶打赏泡币 78双12活动购买礼包 79双12活动获得包裹礼物  80神灯节小程序用户兑换红包泡币奖励 81幸运转盘抽奖泡泡币消费 82 超级转盘抽奖泡泡币消费,83点亮神灯礼物 84 转盘抽奖奖励 85 神灯节任务奖励 86.支付宝转账 87.座驾购买（显示不下请加mp_bill_small_type)")
    private Integer smallType;
	
	    //账单标题
    @TableField("title")
    @ApiModelProperty(value="账单标题")
    private String title;
	
	    //金额
    @TableField("money")
    @ApiModelProperty(value="金额")
    private BigDecimal money;
	
	    //金额单位，0人民币，1泡泡币 ，2 肥皂币
    @TableField("money_unit")
    @ApiModelProperty(value="金额单位，0人民币，1泡泡币 ，2 肥皂币")
    private Integer moneyUnit;
	
	    //内部流水号
    @TableField("in_flow_num")
    @ApiModelProperty(value="内部流水号")
    private String inFlowNum;
	
	    //外部流水号，比如支付宝订单号，如果是打赏，是打赏配置id
    @TableField("out_flow_num")
    @ApiModelProperty(value="外部流水号，比如支付宝订单号，如果是打赏，是打赏配置id")
    private String outFlowNum;
	
	    //渠道 0支付宝  1微信 ，2 app内购(ios)，3账号余额,4-普通动态,5-技能动态, 6-个人主页,7-约单，8其他，9官方 ，10豪车游戏 , 11直播 ,12派单室，13代理，14声优打赏,15求生活动,16头条余额兑换，17 pk宝箱,18赏金猎人,19网咖活动 20.线下打款,21电台打赏，22闪聊打赏，23运营活动 ，25视频闪聊，26语音闪聊，27聊天室打赏
    @TableField("channel")
    @ApiModelProperty(value="渠道 0支付宝  1微信 ，2 app内购(ios)，3账号余额,4-普通动态,5-技能动态, 6-个人主页,7-约单，8其他，9官方 ，10豪车游戏 , 11直播 ,12派单室，13代理，14声优打赏,15求生活动,16头条余额兑换，17 pk宝箱,18赏金猎人,19网咖活动 20.线下打款,21电台打赏，22闪聊打赏，23运营活动 ，25视频闪聊，26语音闪聊，27聊天室打赏")
    private Integer channel;
	
	    //第三方id，比如订单id,(V3.5.1兑换礼物收益关联收益审核账单表id)
    @TableField("common_id")
    @ApiModelProperty(value="第三方id，比如订单id,(V3.5.1兑换礼物收益关联收益审核账单表id)")
    private Long commonId;
	
	    //只有打赏的时候有值，普通动态id,技能动态id, 个人主页id
    @TableField("value_id")
    @ApiModelProperty(value="只有打赏的时候有值，普通动态id,技能动态id, 个人主页id")
    private Long valueId;
	
	    //设备号
    @TableField("equip_num")
    @ApiModelProperty(value="设备号")
    private String equipNum;
	
	    //真钱，金额有比例转换时有效，其余为0
    @TableField("real_money")
    @ApiModelProperty(value="真钱，金额有比例转换时有效，其余为0")
    private BigDecimal realMoney;
	
	    //0未审核 1审核通过 2冻结 3审核中(弃用)
    @TableField("is_adopt")
    @ApiModelProperty(value="0未审核 1审核通过 2冻结 3审核中(弃用)")
    private Integer isAdopt;
	
	    //冒泡提成
    @TableField("mp_money")
    @ApiModelProperty(value="冒泡提成")
    private BigDecimal mpMoney;
	
}
