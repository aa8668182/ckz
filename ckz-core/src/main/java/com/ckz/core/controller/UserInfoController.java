package com.ckz.core.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ckz.core.common.BaseController;
import com.ckz.core.entity.UserInfo;
import com.ckz.core.service.UserInfoService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;


/**
 * 用户详情表
 *
 * @author ckz
 * @email 不告诉你
 * @date 2019-02-18 16:31:34
 */
@RestController
@RequestMapping(value="userInfo", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
@Slf4j
@Api(description = "用户详情")
public class UserInfoController extends BaseController<UserInfoService, UserInfo> {
    public static void main(String[] args) {
        String s = "[{\"transaction_id\":\"1000000529553024\",\"original_purchase_date\":\"2019-05-21 07:13:13 Etc/GMT\",\"quantity\":\"1\",\"original_transaction_id\":\"1000000529553024\",\"purchase_date_pst\":\"2019-05-21 00:13:13 America/Los_Angeles\",\"original_purchase_date_ms\":\"1558422793000\",\"purchase_date_ms\":\"1558422793000\",\"product_id\":\"MVIP\",\"original_purchase_date_pst\":\"2019-05-21 00:13:13 America/Los_Angeles\",\"is_trial_period\":\"false\",\"purchase_date\":\"2019-05-21 07:13:13 Etc/GMT\"},{\"transaction_id\":\"1000000529574915\",\"original_purchase_date\":\"2019-05-21 07:58:06 Etc/GMT\",\"quantity\":\"1\",\"original_transaction_id\":\"1000000529574915\",\"purchase_date_pst\":\"2019-05-21 00:58:06 America/Los_Angeles\",\"original_purchase_date_ms\":\"1558425486000\",\"purchase_date_ms\":\"1558425486000\",\"product_id\":\"MVIP\",\"original_purchase_date_pst\":\"2019-05-21 00:58:06 America/Los_Angeles\",\"is_trial_period\":\"false\",\"purchase_date\":\"2019-05-21 07:58:06 Etc/GMT\"},{\"transaction_id\":\"1000000529576852\",\"original_purchase_date\":\"2019-05-21 08:00:59 Etc/GMT\",\"quantity\":\"1\",\"original_transaction_id\":\"1000000529576852\",\"purchase_date_pst\":\"2019-05-21 01:00:59 America/Los_Angeles\",\"original_purchase_date_ms\":\"1558425659000\",\"purchase_date_ms\":\"1558425659000\",\"product_id\":\"MVIP\",\"original_purchase_date_pst\":\"2019-05-21 01:00:59 America/Los_Angeles\",\"is_trial_period\":\"false\",\"purchase_date\":\"2019-05-21 08:00:59 Etc/GMT\"},{\"transaction_id\":\"1000000529577060\",\"original_purchase_date\":\"2019-05-21 08:01:25 Etc/GMT\",\"quantity\":\"1\",\"original_transaction_id\":\"1000000529577060\",\"purchase_date_pst\":\"2019-05-21 01:01:25 America/Los_Angeles\",\"original_purchase_date_ms\":\"1558425685000\",\"purchase_date_ms\":\"1558425685000\",\"product_id\":\"MVIP\",\"original_purchase_date_pst\":\"2019-05-21 01:01:25 America/Los_Angeles\",\"is_trial_period\":\"false\",\"purchase_date\":\"2019-05-21 08:01:25 Etc/GMT\"},{\"transaction_id\":\"1000000529581276\",\"original_purchase_date\":\"2019-05-21 08:08:09 Etc/GMT\",\"quantity\":\"1\",\"original_transaction_id\":\"1000000529581276\",\"purchase_date_pst\":\"2019-05-21 01:08:09 America/Los_Angeles\",\"original_purchase_date_ms\":\"1558426089000\",\"purchase_date_ms\":\"1558426089000\",\"product_id\":\"MVIP\",\"original_purchase_date_pst\":\"2019-05-21 01:08:09 America/Los_Angeles\",\"is_trial_period\":\"false\",\"purchase_date\":\"2019-05-21 08:08:09 Etc/GMT\"},{\"transaction_id\":\"1000000529554567\",\"original_purchase_date\":\"2019-05-21 07:14:31 Etc/GMT\",\"quantity\":\"1\",\"original_transaction_id\":\"1000000529554567\",\"purchase_date_pst\":\"2019-05-21 00:14:31 America/Los_Angeles\",\"original_purchase_date_ms\":\"1558422871000\",\"purchase_date_ms\":\"1558422871000\",\"product_id\":\"MSVIP\",\"original_purchase_date_pst\":\"2019-05-21 00:14:31 America/Los_Angeles\",\"is_trial_period\":\"false\",\"purchase_date\":\"2019-05-21 07:14:31 Etc/GMT\"},{\"transaction_id\":\"1000000529568375\",\"original_purchase_date\":\"2019-05-21 07:46:27 Etc/GMT\",\"quantity\":\"1\",\"original_transaction_id\":\"1000000529568375\",\"purchase_date_pst\":\"2019-05-21 00:46:27 America/Los_Angeles\",\"original_purchase_date_ms\":\"1558424787000\",\"purchase_date_ms\":\"1558424787000\",\"product_id\":\"MSVIP\",\"original_purchase_date_pst\":\"2019-05-21 00:46:27 America/Los_Angeles\",\"is_trial_period\":\"false\",\"purchase_date\":\"2019-05-21 07:46:27 Etc/GMT\"},{\"transaction_id\":\"1000000529568741\",\"original_purchase_date\":\"2019-05-21 07:47:53 Etc/GMT\",\"quantity\":\"1\",\"original_transaction_id\":\"1000000529568741\",\"purchase_date_pst\":\"2019-05-21 00:47:53 America/Los_Angeles\",\"original_purchase_date_ms\":\"1558424873000\",\"purchase_date_ms\":\"1558424873000\",\"product_id\":\"MSVIP\",\"original_purchase_date_pst\":\"2019-05-21 00:47:53 America/Los_Angeles\",\"is_trial_period\":\"false\",\"purchase_date\":\"2019-05-21 07:47:53 Etc/GMT\"},{\"transaction_id\":\"1000000529571647\",\"original_purchase_date\":\"2019-05-21 07:50:30 Etc/GMT\",\"quantity\":\"1\",\"original_transaction_id\":\"1000000529571647\",\"purchase_date_pst\":\"2019-05-21 00:50:30 America/Los_Angeles\",\"original_purchase_date_ms\":\"1558425030000\",\"purchase_date_ms\":\"1558425030000\",\"product_id\":\"MSVIP\",\"original_purchase_date_pst\":\"2019-05-21 00:50:30 America/Los_Angeles\",\"is_trial_period\":\"false\",\"purchase_date\":\"2019-05-21 07:50:30 Etc/GMT\"},{\"transaction_id\":\"1000000529574706\",\"original_purchase_date\":\"2019-05-21 07:56:52 Etc/GMT\",\"quantity\":\"1\",\"original_transaction_id\":\"1000000529574706\",\"purchase_date_pst\":\"2019-05-21 00:56:52 America/Los_Angeles\",\"original_purchase_date_ms\":\"1558425412000\",\"purchase_date_ms\":\"1558425412000\",\"product_id\":\"MSVIP\",\"original_purchase_date_pst\":\"2019-05-21 00:56:52 America/Los_Angeles\",\"is_trial_period\":\"false\",\"purchase_date\":\"2019-05-21 07:56:52 Etc/GMT\"},{\"transaction_id\":\"1000000529574886\",\"original_purchase_date\":\"2019-05-21 07:57:41 Etc/GMT\",\"quantity\":\"1\",\"original_transaction_id\":\"1000000529574886\",\"purchase_date_pst\":\"2019-05-21 00:57:41 America/Los_Angeles\",\"original_purchase_date_ms\":\"1558425461000\",\"purchase_date_ms\":\"1558425461000\",\"product_id\":\"YSVIP\",\"original_purchase_date_pst\":\"2019-05-21 00:57:41 America/Los_Angeles\",\"is_trial_period\":\"false\",\"purchase_date\":\"2019-05-21 07:57:41 Etc/GMT\"}] \n";
//        String substring = s.substring(s.indexOf("[") + 1, s.lastIndexOf("]"));
        JSONArray in_appJson = JSONArray.parseArray(s);
//        System.out.println(in_appJson.toJSONString());



            Optional<Object> first = in_appJson.stream().sorted((a, b) -> {
                Map<String, Object> beanMapA = (Map<String, Object>) a;
                Map<String, Object> beanMapB = (Map<String, Object>) b;


//                BeanMap beanMapA = new BeanMap(a);
//                BeanMap beanMapB = new BeanMap(b);
                String dateA = (String) beanMapA.get("purchase_date");
                String dateB = (String) beanMapB.get("purchase_date");
                return dateB.compareTo(dateA);
            }).findFirst();
            Map beanMap = (Map)first.get();
            String product_id = (String) beanMap.get("product_id");
            // 订单号
            String transaction_id = (String) beanMap.get("transaction_id");
            String original_transaction_id = (String) beanMap.get("original_transaction_id");
                //时间
//            Long  purchase_date_ms = (Long) beanMap.get("purchase_date_ms");
        System.out.println(product_id+"----"+transaction_id);

    }
}