/*
 * Copyright 2013 NINGPAI, Inc.All rights reserved.
 * NINGPAI PROPRIETARY / CONFIDENTIAL.USE is subject to licence terms.
 */
package com.ningpai.common.util;

import java.text.DecimalFormat;
import java.util.regex.Pattern;

/**
 * 重复字符串定义
 * 
 * @author NINGPAI-LIH
 * @since 2015年2月25日17:49:03
 *
 */
public class ConstantUtil {

    // 第三方标示
    public static final String THIRDID = "thirdId";

    // 分页工具
    public static final String PAGEBEAN = "pageBean";

    // 分页工具
    public static final String PB = "pb";

    // map
    public static final String MAP = "map";

    public static final String CUSTOMERID = "customerId";

    public static final String ISOUTIL = "ISO-8859-1";

    public static final String UTFUTIL = ConstantUtil.UTF;

    public static final String CSRFTOKEN = "CSRFToken";

    public static final String CSRF = "&CSRFToken=";

    public static final String ORDERID = "orderId";

    public static final String OPENID = "openid";

    public static final String UTF = "utf-8";

    public static final String WIDTH = "width";

    public static final String HEIGHT = "height";

    public static final String QUERYID ="queryId";

    /**
     * 标记：是
     */
    public static final int YES = 1;

    /**
     * 标记：否
     */
    public static final int NO = 0;

    /**
     * 区县id的全局默认值
     */
    public static Long DISTINCT_DEF_VALUE = 1103L;


    private final static String MONEY_DIMES_FMT = "0.0";

    private final static String MONEY_CENTS_FMT = "0.00";

    private final static String MONEY_INTEGER_FMT = "0";

    private final static String MONEY_LIKE_FMT = "#.##";

    private ConstantUtil() {
    }

    public static String fmtIntegerMoney(Object obj){
        return fmt(obj,MONEY_INTEGER_FMT);
    }

    public static String fmtCentsMoney(Object obj){
        return fmt(obj,MONEY_CENTS_FMT);
    }

    public static String fmtDimesMoney(Object obj){
        return fmt(obj,MONEY_DIMES_FMT);
    }

    public static String fmtLikeMoney(Object obj){
        return fmt(obj,MONEY_LIKE_FMT);
    }

    public static String fmt(Object obj, String fmt){
        return obj == null ? "" : new DecimalFormat(fmt).format(obj);
    }

    public static boolean find(String str, String regex){
        return Pattern.compile(regex).matcher(str).find();
    }

}
