package com.ckz.core.enums;

/**
 * @author wujilu
 * @类描述：账单记录小类
 * @Date Created in 15:33 2018/5/21
 */
public enum BillSmallTypeEnum {
    //具体类型，0其他，1余额充值，2余额活动奖励，3订单退款，4订单消费，5订单收入，
    // 6礼物兑换，7收益活动奖励，8收入提现，9充值，10泡泡币活动奖励，11任务奖励，12送礼打赏
    //OTYER_SMALL(0, "其他"),
    OFFICIAL_DEDUCTION(0,"官方扣款"),
    SURPLUS_RECHARGE(1, "现金充值"),
    SURPLUS_ACTIVE_REWARD(2, "余额活动奖励"),
    ORDER_REFUND(3, "约单退款"),
    ORDER_CUSTOMER(4, "约单消费"),
    ORDER_INCOME(5, "订单收入"),
    GIFT_EXCHANGE(6, "礼物兑换"),
    PROFIT_ACTIVE_REWARD(7, "收益活动奖励"),
    INCOME_PUT_FORWARD(8, "收入提现"),

    CUSTOM_BUY(27, "课程购买"),
    CUSTOM_REFUND(32, "课程退款"),

    TREASURE_BOX_REWARD(18, "宝箱奖励"),
    BUBBLE_RECHARGE(9, "现金充值"),
    INVITE_FRIENDS_REWARD(10,"邀请好友"),
    BUBBLE_ACTIVE_REWARD(10, "泡泡币活动奖励"),
    INVITE_FRIENDS_BE_TALENT_REWARD(14,"邀请好友成为达人"),
    OFFICIAL_ACTIVITY_REWARD(15,"官方活动奖励"),
    TASK_REWARD(11, "任务奖励"),
    SIGN_IN_REWARD(13,"签到奖励"),
    LIVE_REWARD(31,"直播间泡币中奖"),
    LIVE_GET_REWARD(36,"秀场直播间获赠"),
    GRAB_LUXURY_CAR_GET(19,"抢豪车获得"),
    PROXY_RECHARGE(29,"充值"),
    PROXY_OUT_RECHARGE(34,"转账"),

    LIVE_GIVE_GIFT_REWARD(22,"直播间打赏"),
    BARRAGE_CONSUMPTION(24,"弹幕支出"),
    GIVE_GIFT_REWARD(12, "普通打赏"),
    ORDER_ROOM_REWARD(12,"派单厅打赏"),
    VOICE_ACTOR_REWARD(12,"声优专区打赏"),
    GRAB_LUXURY_CAR_BARRAGE_CONSUMPTION(19,"抢豪车消耗"),
    VOICE_ROOM_REWARD(33,"派单厅礼物打赏"),
    TRICK_BUY(37,"特效购买"),
    OBTAIN_REWARD_PROFIT(39,"获得礼物收益"),
    PK_BOX_REWARD(50,"pk宝箱"),
    CONSUME_CASH_BACK(48,"消费返现"),
    BUBBLE_DEPOSIT_LUCKYDRAW(99,"充值抽奖泡泡币"),

    LIVE_GET_SOAP(21,"直播间打赏获得肥皂币"),
    LIVE_SING_SANG(47,"主播被点歌获得肥皂币"),

    FLASH_CHAT_VIDEO_PAY(65,"闪聊视频消费"),
    FLASH_CHAT_VOICE_PAY(66,"闪聊语音消费"),
    FLASH_CHAT_VIDEO_EARNING(67,"闪聊视频收益"),
    FLASH_CHAT_VOICE_EARNING(68,"闪聊语音收益"),

    ASTT_EXCHANGE_BUBBLE(17,"爱上头条余额购买"),
    BUBBLE_RECHARGE_AWARD(54, "月首充奖励泡币"),
    CALENDAR_GODDESS_AWARD(73, "日历女神奖励泡币"),
    MAGIC_LAMP_AWARD(80, "神灯节礼物"),
    FLASH_CHAT_MINUTE_RECORD(101, "闪聊每分钟记录"),
    EMOTION_FM_CUSTOM_BUY(103,"情感FM课程购买"),
    ;

    private Integer code;

    private String value;

    BillSmallTypeEnum(Integer code, String value){
        this.code = code;
        this.value = value;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
