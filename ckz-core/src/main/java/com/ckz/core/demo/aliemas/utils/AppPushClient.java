package com.ckz.core.demo.aliemas.utils;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.push.model.v20160801.PushRequest;
import com.aliyuncs.push.model.v20160801.PushResponse;
import com.aliyuncs.utils.ParameterHelper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

/**
 * Created by cholen on 2018/5/8.
 */


@Component
public class AppPushClient {

    private DefaultAcsClient client;

    @Value("${accessKeyId}")
    private String accessKeyId;

    @Value("${accessKeySecret}")
    private String accessKeySecret;

    @Value("${regionId}")
    private String region;

    /*ios*/
    @Value("${appKey0}")
    private long appKey0;

    /*安卓*/
    @Value("${appKey1}")
    private long appKey1;


    @PostConstruct
    public void init() throws Exception {
        IClientProfile profile = DefaultProfile.getProfile(region, accessKeyId, accessKeySecret);
        client = new DefaultAcsClient(profile);
    }


    /**
     *
     * @param deviceId 设备Id
     * @param type 类型0 ios 1 安卓
     * @param title 消息标题
     * @param body 消息体
     * @param msgType 推送还是消息 为null是推送
     * @param url 跳转的url
     * @throws ClientException
     */
    public void pushMessage(String deviceId,String type,String title ,String body,String msgType,String url,Map<String,Object> extraMsg) throws ClientException {
        if(StringUtils.isBlank(deviceId)||StringUtils.isBlank(type)||StringUtils.isBlank(title)||StringUtils.isBlank(body)){
            return;
        }
        PushRequest pushRequest = new PushRequest();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("url",url);
        if(!Objects.isNull(extraMsg)){
            jsonObject.putAll(extraMsg);
        }
        String jsonUrl = jsonObject.toString();
        // 推送目标
        if("1".equals(type)){
            //安卓
            pushRequest.setAppKey(appKey1);
            pushRequest.setAndroidNotifyType("VIBRATE");//通知的提醒方式 "VIBRATE" : 震动 "SOUND" : 声音 "BOTH" : 声音和震动 NONE : 静音
            pushRequest.setAndroidNotificationBarType(1);//通知栏自定义样式0-100
            pushRequest.setAndroidNotificationBarPriority(1);//通知栏自定义样式0-100
            if(StringUtils.isBlank(url)){
                pushRequest.setAndroidOpenType("ACTIVITY"); //点击通知后动作 "APPLICATION" : 打开应用 "ACTIVITY" : 打开AndroidActivity "URL" : 打开URL "NONE" : 无跳转
            }else{
                pushRequest.setAndroidOpenType("URL"); //点击通知后动作 "APPLICATION" : 打开应用 "ACTIVITY" : 打开AndroidActivity "URL" : 打开URL "NONE" : 无跳转
            }
            pushRequest.setAndroidOpenUrl(url); //Android收到推送后打开对应的url,仅当AndroidOpenType="URL"有效
            pushRequest.setAndroidMusic("default"); // Android通知音乐
            pushRequest.setAndroidActivity("com.yigou.app"); // 设定通知打开的activity，仅当AndroidOpenType="Activity"有效

            pushRequest.setAndroidPopupActivity("com.ali.demo.PopupActivity");//设置该参数后启动辅助弹窗功能, 此处指定通知点击后跳转的Activity（辅助弹窗的前提条件：1. 集成第三方辅助通道；2. StoreOffline参数设为true）
            pushRequest.setAndroidExtParameters(jsonUrl); //设定通知的扩展属性。(注意 : 该参数要以 json map 的格式传入,否则会解析出错)

            pushRequest.setAndroidPopupTitle("Popup Title"); //设置辅助弹窗通知的标题
            pushRequest.setAndroidPopupBody("Popup Body"); //设置辅助弹窗通知的内容

        }else{
            //ios
            pushRequest.setAppKey(appKey0);
            pushRequest.setIOSBadge(5); // iOS应用图标右上角角标
            pushRequest.setIOSMusic("default"); // iOS通知声音
            pushRequest.setIOSApnsEnv("PRODUCT");//iOS的通知是通过APNs中心来发送的，需要填写对应的环境信息。"DEV" : 表示开发环境 "PRODUCT" : 表示生产环境
            pushRequest.setIOSRemind(true); // 消息推送时设备不在线（既与移动推送的服务端的长连接通道不通），则这条推送会做为通知，通过苹果的APNs通道送达一次。注意：离线消息转通知仅适用于生产环境
            pushRequest.setIOSRemindBody(body);//iOS消息转通知时使用的iOS通知内容，仅当iOSApnsEnv=PRODUCT && iOSRemind为true时有效

            pushRequest.setIOSExtParameters(jsonUrl); //通知的扩展属性(注意 : 该参数要以json map的格式传入,否则会解析出错)
        }
        pushRequest.setTarget("DEVICE"); //推送目标: DEVICE:按设备推送 ALIAS : 按别名推送 ACCOUNT:按帐号推送  TAG:按标签推送; ALL: 广播推送
        pushRequest.setTargetValue(deviceId); //根据Target来设定，如Target=DEVICE, 则对应的值为 设备id1,设备id2. 多个值使用逗号分隔.(帐号与设备有一次最多100个的限制)
        if(StringUtils.isBlank(msgType)){
            pushRequest.setPushType("NOTICE"); // 消息类型 MESSAGE NOTICE
        }else{
            pushRequest.setPushType("MESSAGE"); // 消息类型 MESSAGE NOTICE
        }
        pushRequest.setDeviceType("ALL"); // 设备类型 ANDROID iOS ALL.

        // 推送配置
        pushRequest.setTitle(title); // 消息的标题
        pushRequest.setBody(body); // 消息的内容

        // 推送控制
        Date pushDate = new Date(System.currentTimeMillis()) ; // 30秒之间的时间点, 也可以设置成你指定固定时间
        String pushTime = ParameterHelper.getISO8601Time(pushDate);
//        pushRequest.setPushTime(pushTime); // 延后推送。可选，如果不设置表示立即推送
        String expireTime = ParameterHelper.getISO8601Time(new Date(System.currentTimeMillis() + 12 * 3600 * 1000)); // 12小时后消息失效, 不会再发送
        pushRequest.setExpireTime(expireTime);
        pushRequest.setStoreOffline(true); // 离线消息是否保存,若保存, 在推送时候，用户即使不在线，下一次上线则会收到
        PushResponse pushResponse = client.getAcsResponse(pushRequest);
        System.out.printf("RequestId: %s, MessageID: %s\n",
                pushResponse.getRequestId(), pushResponse.getMessageId());
    }
}
