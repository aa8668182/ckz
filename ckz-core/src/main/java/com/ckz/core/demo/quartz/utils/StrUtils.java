package com.ckz.core.demo.quartz.utils;

import java.lang.reflect.Field;

/**
 * Created by cholen on 2018/1/24.
 */
public class StrUtils {
    public static String spilt(String str) {
        StringBuffer sb = new StringBuffer();
        String[] temp = str.split(",");
        for (int i = 0; i < temp.length; i++) {
            if (!"".equals(temp[i]) && temp[i] != null)
                sb.append("'" + temp[i] + "',");
        }
        String result = sb.toString();
        String tp = result.substring(result.length() - 1, result.length());
        if (",".equals(tp))
            return result.substring(0, result.length() - 1);
        else
            return result;
    }


    public static boolean checkObjFieldIsNull(Object obj) throws IllegalAccessException {

        boolean flag = true;
        for(Field f : obj.getClass().getDeclaredFields()){
            f.setAccessible(true);
            if(f.get(obj) != null&& !"".equals(f.get(obj))){
                flag = false;
                return flag;
            }
        }
        return flag;
    }
}
