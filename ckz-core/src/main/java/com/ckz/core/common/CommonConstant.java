package com.ckz.core.common;

import java.math.BigDecimal;

/**
 * @author hantao
 * @version V1.0
 * @Title: works
 * @Package common
 * @Description: 公共常量类
 * @date 2017/12/7 11:16
 */
public class CommonConstant {

    public static String USER_CONTEXT = "USER_CONTEXT";

    public static String AMAP_KEY = "7f527cf12a179e68c875d616d5cfb3ba";// 高德key

    public static String AROUND_ULR = "http://yuntuapi.amap.com/datasearch/around";//高德周边检索请求地址

    public static String DATAMANAGE_ULR = "http://yuntuapi.amap.com/datamanage/data/list";//按条件检索数据（可遍历整表数据）

    public static String YUNTU_UPDATE_URL = "http://yuntuapi.amap.com/datamanage/data/update";//高德云存储更新请求
    public static Integer FIRST_PAGE = 10; //v4.0.0首页返回10条
    public static Integer HOMEPAGE_PAGENUM = 20; //首页动态分页，每页显示条数
    public static Integer HOMEPAGE_USER_PAGENUM = 20; //首页人分页，每页显示条数
    public static Integer PAGE_NUM = 20; //分页,统一返回每页显示20条
    public static Integer PAGE_NUM_THIRTY = 30; //分页,统一返回每页显示30条
    public static Integer TANPAGE_USER_PAGENUM = 10;//弹弹用户分页，每条显示条数
    public static Integer FANS_PAGENUM = 20;//弹弹用户分页，每条显示条数
    public static Integer SEND_CODE_COUNT = 20;//用户每天限制发送验证码次数
    public static Integer RECOMMEND_USER_PAGENUM = 10; //首页推荐用户分页
    public static final Integer ACTIVE_WISHING_RANK_PAGENUM = 10;//神灯活动排行榜分页

    public static final String FILE_CLOUD_PATH = "http://oss-cn-hangzhou.aliyuncs.com/";//oss请求路径


    /**登录验证token*/
    public static final String TOKEN = "token";

    public static final String NETTYPE = "netType";//设备类型  a安卓  i IOS

    public static final String APPVERSION = "appVersion";  //APP版本号

    public static final String SIGN = "sign";   //登陆加签(token的MD5) 没有传空字符串

    public static final String USERID = "userId";  //用户ID

    /**融云--冒泡**/
    public static final String MAOPAO_STR = "maopao";

    public static final int TOKEN_SUSSESS = 200;

    public static final String SMS_PARAM = "${param}";

    public static final String HTTP_STR = "http";

    public static final String SYSTEM_NOTICE = "系统消息";

    public static final String MESSAGE_COUNT = "_bubble_message_count";//活动通知存到缓存中，拼接

    //用户卡片信息存到缓存中，的key
    public static final String CARD_PRESRVATION_SEVEN = "_card_presrvation_seven";
    //7天
    public static final long SEVEN_DAY = 7*24*60*60;
    //3天
    public static final long THREE_DAY = 3*24*60*60;
    //1天
    public static final long ONE_DAY = 24*60*60;
    //2天
    public static final long TWO_DAY = 2*24*60*60;
    //用户喜欢我的列表存到缓存中，的key
    public static final String USER_LIKE_MINE_LIST = "_user_like_mine_list";
    //当前用户喜欢列表，用于过滤
    public static final String CURRENT_USER_LIKE_MINE_LIST = "_current_user_like_mine_list";
    //不喜欢卡片存到缓存中的key
    public static final String MINE_DISLIKE_USER = "_mine_dislike_user";
    //用户划拉了卡片数，存到缓存
    public static final String USER_XX_CARD_COUNT = "_user_xx_card_count";
    //每天喜欢的卡片数量计数
    public static final String EVERY_DAY_BELIKE_CARD_COUNT="_every_day_belike_card_count";
    /**
     * 省 市 区 数据 redis存储key
     */
    public static final String PROVINCE_CITY_AREA = "province_city_area_list";
    public static final String PROVINCE_DATA_LIST = "province_data_list";
    public static final String CITY_DATA_LIST = "province_data_list";
    public static final Integer PROVINCE_LEVEL = 1;
    public static final Integer CITY_LEVEL = 2;
    public static final Integer AREA_LEVEL = 3;

    public static final Integer DEFOUT_GROUP_DISPLAY_NUMBER = 10;

    /**
     * 默认数据 避免null
     */
    public static String APIRESPONSE_DEFAULT_DATA = "";

    //互动消息数量存到缓存 InteractionMessage
    public static final String INTERACTION_MESSAGE_COUNT = "_interaction_message_count";

    //用户互动消息数量
    public static final String INTERACTION_MESSAGE_USER_COUNT = "_interaction_message_user_count_";

    //互动消息推送人ID集合
    public static final String INTERACTION_MESSAGE_SEND_ID = "_interaction_message_send_id_";

    //互动消息匿名数量
    public static final String INTERACTION_MESSAGE_ANONYMITY_COUNT = "_interaction_message_anonymity_count_";

    //系统消息数量存到缓存 SystemMessage
    public static final String SYSTEM_MESSAGE_COUNT = "_system_message_count";

    //订单消息数量存到缓存 OrderMessage
    public static final String ORDER_MESSAGE_COUNT = "_order_message_count";

    //宠物消息数量存到缓存
    public static final String PET_MESSAGE_COUNT = "_pet_message_count";

    //订单消息支付之后保存
    public static final String ORDER_WARN = "order_warn_";

    //泡泡组建的群和泡泡关联上存到缓存,通过群id查询泡泡id
    public static final String BUBBLE_GROUP_AND_BUBBLE = "_bubble_group_and_bubble";

    //泡泡组建的群和泡泡关联上存到缓存,通过泡泡id查询群id
    public static final String BUBBLE_AND_GROUP_RELATE = "_bubble_bubble_and_group";

    public static final String TWO_BUBBLE_AND_GROUP_RELATE = "_one_day_bubble_bubble_and_group";

    //秒杀活动达人的订单库存量
    public static final String SECKILL_ORDER_STOCK ="seckill_%s_order_stock_%s";

    //秒杀活动用户抢单记录缓存 activeId,teacherId
    public static final String SECKILL_ORDER_USER ="seckill_order_user_%s";

    //冒泡小助手提示语
    public static final String MAOPP_SMALL_HELP_WORDS = " 冒泡小助手提示您：冒泡旨在打造良好的线下社交模式，但在与陌生好友见面时，也请保护好个人隐私，加强自我防范意识，警惕各类投资、借贷、赌毒等诈骗方式，如遇可疑账号，请及时举报，我们核实后会对其账号进行加黑处理。";
    
    /** 缓存常量 **/
    public static final String DYNAMIC_PRAISE = "_dynamic_praise"; //增加点赞数拼接用

    //邀请好友或被邀请人获得的泡泡币
    public static final BigDecimal OFFICIAL_AWARD = new BigDecimal(100);

    //技能评分缓存redis
    public static final String SKILL_SCORE = "score%s"; //%s认证技能的用户id

    //技能评分缓存redis
    public static final String SKILL_EVALUATE = "SKILL_EVALUATE_"; //%s认证技能的用户id

    /** 敏感词相关 **/

    //AppCode
    public static final String APPCODE = "d30e03d6735743f7af9b4f84e504fc11";

    //AppKey
    public static final String APPKEY = "24870783";

    //AppSecret
    public static final String APPSECRET = "01a17e9cf077d5cb7bb0000837374e48";

    //host
    public static final String HOST = "http://apistore.tongchengyue.com";

    //path
    //判断一段话是否包含敏感词
    public static final String IS_CONTAINS_PATH = "/sw/isContains";

    //过滤敏感词
    public static final String FILTER_PATH = "/sw/doFilter";

    //判断某个词是否是敏感词
    public static final String CHECH_PATH = "/sw/check";


    /**支付-json字符串**/
    public static final String json_format = "json";

    /**支付-utf8 charset**/
    public static final String utf8 = "utf-8";

    /**支付-RSA2**/
    public static final String SIGN_TYPE_RSA2 = "RSA2";


    /** 敏感词文件路径 **/
    public static final String SENSITIVE_WORDS_URL = "https://cdn-static.maopp.cn/backend/sensi_words.txt";

    /** redis互斥锁拼接字符串 **/
    public static final String REDIS_LOCK = "_redis_lock";

    /** redis部落锁 **/
    public static final String REDIS_TRIBE_LOCK = "_redis_tribe_lock";

    /** redis宝箱锁 **/
    public static final String BOX_ONLY_LOCK = "_box_only_lock";

    /*关键字变色*/
    public static final String KEYWORD_URL = "keyword.url";

    /**搜索附近人的范围*/
    public static final double DISTANCE = 5;

    //身份证验后得到的姓名
    public static final String ID_CARD_NAME = "id_card_name_";
    //身份证验证后得到的身份证号码
    public static final String ID_CARD_NUMBER = "id_card_number_";
    //身份证正面
    public static final String ID_CARD_FRONT = "id_card_front_";
    //身份证反面
    public static final String ID_CARD_BACK = "id_card_back_";

    public static final String FACE_TOKEN = "face_token_";

    //关闭房间标识
    public static final String CLOSE_COURSE = "close_course_";


    /**短信验证码验证通过后放入Redis的key*/
    public static final String MSG_KEY = "msg_key_";

    //3分钟
    public static final long THREE_MINUTE = 3*60;
    public static final long FIVE_MINUTE = 5*60;

    public static final long ONE_MINUTE = 60;
    public static final long FIVE = 5;
    public static final long TWENTY = 20;
    public static final long THIRTY = 30;
    public static final long TEN = 10;
    public static final long FIFTY = 50;

    public static final int ONE = 1;//关注  图片


    //风控
    //同一ID/IP账户连续多次请求充值 泡泡币充值
    public static final String ONE_USER_RECHARGE = "_one_user_recharge";

    //同一ID/IP账户连续多次请求充值 余额充值
    public static final String ONE_USER_MONEY = "_one_user_money";

    //同一ID/IP账户连续多次下单
    public static final String MONEY_ADD_ORDER = "_many_add_order";

    //同一ID/IP账户连续多次接单
    public static final String MONEY_RECEIVE_ORDER = "_many_receive_order";
    //同一ID/IP账户连续多次打赏
    public static final String MENY_DO_REWARD = "_many_do_reward";
    //同一ID/IP账户连续多次请求提现
    public static final String MENY_PUT_FORWARD = "_many_put_forward";
    //大量ID/IP连续多次请求充值
    public static final String LARGE_NUM_RECHARGE = "_large_num_recharge";
    //大量ID/IP连续多次下单
    public static final String LARGE_ADD_ORDER = "_large_add_order";
    //大量ID/IP连续多次接单
    public static final String LARGE_RECEIVE_ORDER = "_large_receive_order";
    //大量ID/IP连续多次接单
    public static final String LARGE_DO_REWARD = "_large_do_reward";
    //大量ID/IP账户连续多次请求提现
    public static final String LARGE_PUT_FORWARD = "_large_put_forward";
    //同一ID/IP账户余额内新增泡泡币100000及以上
    public static final String ADD_BALANCE_MONEY = "_add_balance_money";
    //用户/达人在同一个时间段内频繁更改昵称（一天之内，5次）
    public static final String USER_OFTEN_NICK = "_user_often_nick";
    //短时间内充值失败（5分钟内、失败10次以以上）
    public static final String USER_RECHARGE_FAIL = "_user_recharge_fail";
    //同一账户ID/IP邀请用户50名及以上
    public static final String USER_INVITE_FIFTY = "_user_invite_fifty";
    //短时间内大量ID账户礼物盒新增礼物（30个ID及以上、1分钟）
    public static final String ID_ADD_REWARD = "_id_add_reward";
    //短时间内同一ID/IP账户礼物盒多次新增礼物（10次、1分钟）
    public static final String ONE_ADD_REWARD = "_one_add_reward";
    //短时间内大量ID账户未通过充值接口，账户新增泡泡币（30个ID及以上、1分钟）
    public static final String MANY_ID_BULLBE = "_many_id_bubble";
    //短时间内同一IP/ID账户未通过充值接口，账户多次新增泡泡币（10次、3分钟）
    public static final String SHORT_ID_BUBBLE = "_short_id_bubble";

    public static final String FIVE_DO_REWARD = "_five_do_reward";

    /**地图社交常量**/
//    public static final String GEO_HASH_KEY = "_geo_hash_key";  //用户地图位置缓存
    public static final String GEO_HASH_KEY = "_geo_hash_key_1";


    /**客户端编号rediskey**/
    public static final String CLIENT_ID_KEY = "CLIENT_ID_KEY";

    /**用户经度key**/
    public static final String PERSION_LA_KEY = "PERSION_LA_KEY";

    /**用户纬度key**/
    public static final String PERSION_LO_KEY = "PERSION_LO_KEY";

    /**领取宝箱公告内容key*/
    public static final String GET_BOX_CONTENT_KEY = "GET_BOX_CONTENT_KEY";

    /**领取宝箱key*/
    public static final String GET_BOX_KEY = "GET_BOX_KEY";

    /**pkkey*/
    public static final String PK_REDIS_KEY = "PK_REDIS_KEY";

    //把用户头像放到缓存中
    public static final String USER_AVATAR = "_user_avatar";

    /**头像为空时返回默认图*/
    public static final String USER_AVATAR_IS_NULL = "https://cdn-img.maopp.cn/2018-07/bubble-img/1531374520091.png";

    public static final String OK = "OK";

    /**发送弹幕消耗泡泡币**/
    public static final BigDecimal CONSUME_BUBBLE_AMOUNT  = new BigDecimal("10");

    /**发送喇叭消耗泡泡币**/
    public static final BigDecimal CONSUME_BUBBLE_AMOUNT_HORN  = new BigDecimal("1000");

    /**新秀过期时间**/
    public static final Integer ROOKIE_EXPIRED_DAY = 10;

    //神策埋点初始化拼接数据
    public static final String SHENCE_SDK = "shence_sdk_2";
    /**DSP渠道回调地址*/
    public static final String DSP_CALLBACK_URL = "http://s2s.masky.biddingx.com/s2s/mb/postback?adu=%s&imp=%s&chn=%s&did=%s";

    /**MOBVISTA渠道回调地址*/
    public static final String MOBVISTA_CALLBACK_URL = "http://stat.mobvista.com/install?mobvista_pl=%s&mobvista_campuuid=%s&mobvista_clickid=%s&mobvista_gaid=%s&mobvista_type=maopao";

    /**MINTEGRAL自有平台渠道回调地址*/
    public static final String MINTEGRAL_CALLBACK_URL = "http://postback.mintegral.net/install?pl=%s&campuuid=%s&clickid=%s&gaid=%s&type=maopao_mtg";

    /**卓泰渠道回调**/
    public static final String ZHUOTAI_CALLBACK_URL = "http://data.zttx.net/ztact/act.php?appid=%s&idfa=%s&idfamd5=%s&acttime=%s&actip=%s";

    /**UC回调地址*/
    public static final String UC_CALLBACK_URL = "http://huichuan.sm.cn/td?tp_type=roi&callback_param=%s";

    /**网易有道回调地址*/
    public static final String YOU_DAO_CALLBACK_URL = "http://conv.youdao.com/api/track?conv_ext=%s&conv_action=%s";

    /*限时秒杀活动首页入口图片地址*/
    public static final String SECKILL_ENTRANCE_IMG_URL = "seckill.entrance.img.url";

    /*限时秒杀订单消息图片*/
    public static final String SECKILL_IMG_URL = "seckill.order.message.img.url";

    //私人订制改价,(导师id_price_用户id)
    public static final String CUSTOM_MODIFY_PRICE = "_price_";
    //用户封禁KEY 用户ID 手机号
    public static final String BAN_USER = "ban_user_%s";
    //给用户禁言key
    public static final String USER_NO_SPEAK = "user_no_speak";


    /*求生活动邀请人数（邀请方用户Id）*/
    public static final String ACTIVE_INVITE_COUNT = "_invite_count";

    /*求生券的配置ID mp_live_reward_config ID*/
    public static final Long RELATION_GIFT_REWARD_ID = 50l;

    //等级经验值倍数
    public final static int GRADE_MULTIPLE = 5;


    /*求生活动求生券ID*//*
    public static final String RELATION_GIFT_REWARD_ID = "50";
    *//*求生活动邀请人数（邀请方用户ID）*//*
    public static final String ACTIVE_INVITE_COUNT = "_invite_count";*/

    //安卓提示更新语
    public static final String ANDROID_UPDATE_WORDS = "你当前版本过低，请跳转下载最新版本。";
    //ios提示更新语
    public static final String IOS_UPDATE_WORDS = "你当前版本过低，请跳转下载最新版本。";



    public static final String BUBBLE_EXCHANGE_ONE = "_bubble_exchange_one_";


    //私聊限制常量
    public static final String COMPANY = "maopao";
    public static final String TEAM = "live";

    //热门推荐用户拼接 HOT_USER+用户id
    public static final String HOT_USER = "hot_user_";
    //热门推荐的池子 7个池子
    //24小时池子
    public static final String HOT_ONE = "HOT_ONE";
    //24-48小时池子
    public static final String HOT_TWO = "HOT_TWO";
    //48-72小时池子
    public static final String HOT_THREE = "HOT_THREE";
    //72-96小时池子
    public static final String HOT_FOUR = "HOT_FOUR";
    //96-120小时池子
    public static final String HOT_FIVE = "HOT_FIVE";
    //120-144小时池子
    public static final String HOT_SIX = "HOT_SIX";
    //144-168小时池子
    public static final String HOT_SEVEN = "HOT_SEVEN";

    //附近动态用户拼接 NEARBY_USER+用户id
    public static final String NEARBY_USER = "nearby_user_";
    //附近动态的池子 7个池子
    //24小时池子
    public static final String NEARBY_ONE = "NEARBY_ONE";
    //24-48小时池子
    public static final String NEARBY_TWO = "NEARBY_TWO";
    //48-72小时池子
    public static final String NEARBY_THREE = "NEARBY_THREE";
    //72-96小时池子
    public static final String NEARBY_FOUR = "NEARBY_FOUR";
    //96-120小时池子
    public static final String NEARBY_FIVE = "NEARBY_FIVE";
    //120-144小时池子
    public static final String NEARBY_SIX = "NEARBY_SIX";
    //144-168小时池子
    public static final String NEARBY_SEVEN = "NEARBY_SEVEN";

    //性别筛选池子
    //24小时池子
    //男
    public static final String NEARBY_MAN_ONE = "NEARBY_MAN_ONE";
    //24-48小时池子
    public static final String NEARBY_MAN_TWO = "NEARBY_MAN_TWO";
    //48-72小时池子
    public static final String NEARBY_MAN_THREE = "NEARBY_MAN_THREE";
    //72-96小时池子
    public static final String NEARBY_MAN_FOUR = "NEARBY_MAN_FOUR";
    //96-120小时池子
    public static final String NEARBY_MAN_FIVE = "NEARBY_MAN_FIVE";
    //120-144小时池子
    public static final String NEARBY_MAN_SIX = "NEARBY_MAN_SIX";
    //144-168小时池子
    public static final String NEARBY_MAN_SEVEN = "NEARBY_MAN_SEVEN";

    //女
//24小时池子
    public static final String NEARBY_WOMAN_ONE = "NEARBY_WOMAN_ONE";
    //24-48小时池子
    public static final String NEARBY_WOMAN_TWO = "NEARBY_WOMAN_TWO";
    //48-72小时池子
    public static final String NEARBY_WOMAN_THREE = "NEARBY_WOMAN_THREE";
    //72-96小时池子
    public static final String NEARBY_WOMAN_FOUR = "NEARBY_WOMAN_FOUR";
    //96-120小时池子
    public static final String NEARBY_WOMAN_FIVE = "NEARBY_WOMAN_FIVE";
    //120-144小时池子
    public static final String NEARBY_WOMAN_SIX = "NEARBY_WOMAN_SIX";
    //144-168小时池子
    public static final String NEARBY_WOMAN_SEVEN = "NEARBY_WOMAN_SEVEN";

    //首页动态话题详情数据放到redis中
    public static final String DYNAMIC_TOPIC = "dynamic_topic_";

    /**
     * 闪聊认证次数redis  key
     */
    public static final String FLASH_CHAT_AUDIT = "_flash_chat_audit_";
    /**
     * 闪聊获取token记录的redis  key
     */
    public static final String FLASH_CHAT_GET_TOKEN = "_flash_chat_get_token_";
    /**
     * 闪聊房间存在的凭证redis  key
     */
    public static final String FLASH_CHAT_TIME = "_flash_chat_channel_time_";
    /**
     * 闪聊所有频道redis  key
     */
    public static final String FLASH_CHAT_CHANNEL = "flash_chat_all_channel";
    /**
     * 腾讯im sign
     */
    public static final String FLASH_CHAT_SIGN = "flash_chat_sign_";
    /**
     * 腾讯im 群组id
     */
    public static final String FLASH_CHAT_GROUP_ID = "flashChatGroupId";
    /**
     * 送礼数量
     */
    public static final String FLASH_CHAT_REWARD_NUM = "_flash_chat_reward_num_";
    /**
     * 闪聊免费次数key
     */
    public static final String FLASH_CHAT_GRATIS_NUM = "_flash_chat_gratis_num_";
    /**
     * 闪聊限制次数key
     */
    public static final String FLASH_CHAT_ASTRICT = "flash_chat_astrict_";
    /**
     * 记录用户通话前状态
     */
    public static final String FLASH_CHAT_STATE = "flash_chat_state_";
    /**
     * 防止多次关闭key
     */
    public static final String FLASH_CHAT_CLOSE = "flash_chat_close_";

    //主播
    public final static String ANCHOR = "anchor";

    //用户昵称头像key+用户id
    public final static String USER_DATA = "user_";
    public final static String USER_ID = "userId";
    public final static String USER_NICK = "nick";
    public final static String AVATAR = "avatar";
    //用户标识
    //达人
    public final static String TEACHER = "teacher";
    //实名认证
    public final static String REALNAME = "realName";
    //靓号
    public final static String PRETTYSIGN = "prettySign";

    /** 家族引流redis互斥锁拼接字符串 **/
    public static final String REDIS_LOCK_FAMILY = "_redis_lock_family";

    //推荐用户缓存标识
    public final static String RECOMMEND_USER_KEY = "recommend_user_key";

    public static final String GREEN_DEFAULT_USER_NICK = "GREEN_DEFAULT_USER_NICK";

    /**
     * 短视频点赞数
     */
    public final static String SHORT_VIDEO_PRAISE_NUM = "short_video_praise_num:";

    /**
     * 短视频查看数量
     */
    public final static String SHORT_VIDEO_LOOK_NUM = "short_video_look_num:";
    /**
     * 直播间发红包
     */
    public final static String ROOM_RED_PACKET_PRICE_KEY = "ROOM_RED_PACKET_PRICE_KEY";

}
