package com.ckz.core.utils;


public class StringHelper {
    public static String getObjectValue(Object obj){
        return obj==null?"":obj.toString();
    }

    public static void main(String[] args) {
        try {
            throw new RuntimeException("数量错误,请重新输入");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
