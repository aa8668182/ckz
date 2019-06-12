package com.ningpai.common.util;


import com.ningpai.common.util.tenpay.util.TenpayUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hz on 2016/7/25.
 */
public class OrderUtil {
     private static SimpleDateFormat outFormat = new SimpleDateFormat("yyyyMMddHHmmss");
     public static String getCZOrder(){
         return CreateOrderId("CZ");
     }
     public static String getTXOrder(){
        return CreateOrderId("TX");
     }
     public static String getZFOrder() {
         return CreateOrderId("ZF");
     }
     public static String CreateOrderId(String desc){
         Date now = new Date();
         String s = outFormat.format(now);
         int r= TenpayUtil.buildRandom(4);
         String order=desc+s+r;
         return order;
     }
     public static String getCardID(){
         int r= TenpayUtil.buildRandom(6);
         return String.valueOf(r);
     }
     public static void main(String[]arg0){
          System.out.println(OrderUtil.getZFOrder());
          System.out.println(OrderUtil.getCZOrder());
          System.out.println(OrderUtil.getTXOrder());
     }
}
