package com.ckz.core.utils;
import java.util.HashMap;
import java.util.Map;


/**
 * @author: caikaizhen
 * @date: 2019/2/21 10:47
 * @Description:此工具类用于保存上下文线程变量
 */
public class BaseContextHandler {
    public static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<Map<String, Object>>();

    public static void set(String key, Object value) {
        Map<String, Object> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<String, Object>();
            threadLocal.set(map);
        }
        map.put(key, value);
    }

    public static Object get(String key){
        Map<String, Object> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<String, Object>();
            threadLocal.set(map);
        }
        return map.get(key);
    }

    public static String getAppId(){
        Object value = get(CommonConstants.CONTEXT_KEY_APPID);
        return returnObjectValue(value);
    }
    public static String getUserID(){
        Object value = get(CommonConstants.CONTEXT_KEY_USER_ID);
        return returnObjectValue(value);
    }

    public static String getLoginAccount(){
        Object value = get(CommonConstants.CONTEXT_KEY_LOGINACCOUNT);
        return returnObjectValue(value);
    }


    public static String getLoginName(){
        Object value = get(CommonConstants.CONTEXT_KEY_LOGINNAME);
        return StringHelper.getObjectValue(value);
    }

    public static String getToken(){
        Object value = get(CommonConstants.CONTEXT_KEY_TOKEN);
        return StringHelper.getObjectValue(value);
    }

    public static void setAppId(String appId){set(CommonConstants.CONTEXT_KEY_APPID,appId);}

    public static void setToken(String token){set(CommonConstants.CONTEXT_KEY_TOKEN,token);}

    public static void setLoginName(String name){set(CommonConstants.CONTEXT_KEY_LOGINNAME,name);}

    public static void setUserID(String userID){
        set(CommonConstants.CONTEXT_KEY_USER_ID,userID);
    }

    public static void setLoginAccount(String username){
        set(CommonConstants.CONTEXT_KEY_LOGINACCOUNT,username);
    }

    private static String returnObjectValue(Object value) {
        return value==null?null:value.toString();
    }

    public static void remove(){
        threadLocal.remove();
    }
}

