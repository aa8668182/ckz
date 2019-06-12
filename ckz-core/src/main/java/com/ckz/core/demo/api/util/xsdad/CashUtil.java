package com.ningpai.common.util;

import com.ningpai.util.StringUtil;

import java.math.BigDecimal;

/**
 * Created by huhaichao on 2016/12/24.
 */
public class CashUtil {
    /**
     * 把把元转换为分
     * @param price 金额
     * @return
     */
    public static int getCent(BigDecimal price){
        return price.multiply(new BigDecimal(100)).intValue();
    }

    /**
     * 把分转换为元
     * @param txnAmt
     * @return
     */
    public static BigDecimal getYuan(String txnAmt) {
        if(StringUtil.isEmpty(txnAmt)){
            return null;
        }
        return new BigDecimal(txnAmt).divide(new BigDecimal(100));
    }

}
