package com.ningpai.common.util;

/**
 * 缓存的key常量
 * 
 * 特别注意 该接口下 不放放与redis  不相干的属性 并且 变量的名称务必和变量的值 一样 以便启动的时候 删除redis中缓存的key
 * @author djk
 *
 */

public interface CacheKeyConstant
{
	/**
	 * 单页缓存的key
	 */
	String INFORMATIONONEPAGE_KEY = "INFORMATIONONEPAGE_KEY";
	
	/**
	 * 当前模板缓存的key
	 */
	String CURRSYSTEMP_KEY = "CURRSYSTEMP_KEY";
	
	/**
	 * 当前代码统计缓存的key
	 */
	String CURRSTATISTICSCODE_KEY = "CURRSTATISTICSCODE_KEY";
	
	/**
	 * 快商通缓存的key
	 */
	String SHOPKUAISHANG_KEY = "SHOPKUAISHANG_KEY";
	
	/**
	 * 移动版站点基础设置缓存的key
	 */
	String CURRMOBSITEBASIC_KEY = "CURRMOBSITEBASIC_KEY";
	
	/**
	 * SEO缓存的key
	 */
	String SEO_KEY = "SEO_KEY";
	
	/**
	 * 站点信息缓存的key
	 */
	String BASICSET_KEY = "BASICSET_KEY";
	
	/**
	 * 热门晒单缓存的key
	 */
	String TOPSHARE_KEY = "TOPSHARE_KEY";
	
	/**
	 * 帮助缓存的key 
	 */
	String HELPCATELIST_KEY = "HELPCATELIST_KEY";
	
	/**
	 * 底部帮助缓存的key
	 */
	String ALLISFOOT_KEY = "ALLISFOOT_KEY";
	
	/**
	 * 热门搜索缓存的key
	 */
	String HOTSEARCH_KEY = "HOTSEARCH_KEY";
	
	/**
	 * 页面广告缓存的key
	 */
	String CHANNELADVER_KEY = "CHANNELADVER_KEY";

    /**
     * token缓存的key
     */
    String TEMPTOKEN_KEY = "TEMPTOKEN_KEY";

	/**
	 * 区县与仓库对应关系缓存key
	 */
	String WARE_HOUSE_DISTRICT = "WARE_HOUSE_DISTRICT";

	/**
	 * 会员等级的key
	 */
	String LEVEL_KEY = "LEVEL_KEY";

	/**
	 * 省份的key
	 */
	String PROVINCE_KEY = "PROVINCE_KEY";

	/**
	 * 城市的key
	 */
	String CITY_KEY = "CITY_KEY";

	/**
	 * 区县的key
	 */
	String DISTRICT_KEY = "DISTRICT_KEY";

	/**
	 * 默认区县的key
	 */
	String DEF_DISTRICT_KEY = "DEF_DISTRICT_KEY";

	String MINI_CART_KEY_PREFIX = "MINI_CART_";

	/**
	 * 退单订单id key
	 */
	String BACK_ORDER_KEY_PREFIX = "BACK_ORDER_ID_";

	/**
	 * 生成sku索引 key
 	 */
	String CREATING_SKU_INDEX = "CREATING_SKU_INDEX";

	/**
	 * 生成sku索引 key
	 */
	String COUPON_INDEX = "COUPON_INDEX";

	/**
	 * 预存款支付 key
	 */
	String REDUCE_DEPOSIZE_PREFIX = "REDUCE_DEPOSIZE_";
}
