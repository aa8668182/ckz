package com.ningpai.common.util;

import com.ningpai.datarouter.CCContext;
import com.ningpai.datarouter.DataRouterCommon;
import com.ningpai.redis.RedisHsetBean;
import com.ningpai.util.MyLogger;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * redis 工具类
 *
 * 由于原来使用此工具类时，无论新增还是查询，key都是固定的字段，所以在此为所有方法的key都加上了cc
 * 但如果使用Redis原生方法获得key，是带有cc的，用这个keywithcc调用此类的方法，会被重复加上cc，使用时要注意
 * @author djk
 */
public class RedisMap {

    private static final MyLogger DEBUG = new MyLogger(RedisMap.class);
    /**
     * 注入redis的模板
     */
    @SuppressWarnings("unchecked")
    @Resource
    private static RedisTemplate<String, Serializable> redisTemplate = (RedisTemplate<String, Serializable>) ApplicationContextHelper.getBean("redisTemplate");

    /**
     * 是否需要redis
     */
    private static boolean isNeedRedis = false;

    private static String getCCKey(String originKey) {
        String useCC = CCContext.getContextCC();
        if (DataRouterCommon.NO_CC.equals(useCC)) {
            return originKey;
        }else if (useCC == null){
            return originKey;
        }else if (StringUtils.isEmpty(useCC)) {
            throw new RuntimeException("redis no cc");
        } else {
            return useCC + originKey;
        }
    }

    static {
        try {
            Properties properties = new Properties();
            properties.load(RedisMap.class.getClassLoader().getResourceAsStream("com/ningpai/web/config/redis.properties"));
            String value = (String) properties.get("redis.start");

            if ("yes".equals(value)) {
                isNeedRedis = true;
            }

            DEBUG.debug("Load redis success and redis start flag :" + isNeedRedis);

        } catch (Exception e) {
            DEBUG.error("Load redis.properties fail", e);
        }
    }

    /**
     * 删除所有缓存
     */
    public static void deleteAll() {
        // 如果redis 不需要 则直接返回
        if (!isNeedRedis) {
            return;
        }

        // 活动所有缓存的key值
        List<String> keys = getAllCacheKeys();

        DEBUG.debug("Begin to delete keys :" + keys);

        if (!CollectionUtils.isEmpty(keys)) {
            try {
                redisTemplate.delete(new ArrayList<String>(keys));
            } catch (Exception e) {
                DEBUG.error("DeleteAll Fail..." + keys);
            }
        }

    }

    /**
     * 获得所有缓存的key
     *
     * @return
     */
    private static List<String> getAllCacheKeys() {
        List<String> keys = new ArrayList<String>();

        Class<CacheKeyConstant> class1 = CacheKeyConstant.class;

        Field[] fields = class1.getDeclaredFields();

        for (Field field : fields) {
            keys.add(getCCKey(field.getName()));
        }

        return keys;

    }


    /**
     * 根据key删除缓存
     *
     * @param key
     * @return
     */
    public static void delete(final String key) {
        // 如果redis 不需要 则直接返回
        if (!isNeedRedis) {
            return;
        }
        String keyWithCC = getCCKey(key);
        try {
            redisTemplate.delete(keyWithCC);
        } catch (Exception e) {
            DEBUG.error("Delete cache fail and key : " + key);
        }
    }

    /**
     * 保存数据到redis中
     */
    public static boolean put(String key, final Serializable value) {
        // 如果redis 不需要 则直接返回
        if (!isNeedRedis) {
            return true;
        }
        String keyWithCC = getCCKey(key);
        try {
            return redisTemplate.execute(new RedisCallback<Boolean>() {
                @Override
                public Boolean doInRedis(RedisConnection connection)
                        throws DataAccessException {
                    connection.set(redisTemplate.getStringSerializer().serialize(keyWithCC), new JdkSerializationRedisSerializer().serialize(value));
                    return true;
                }
            });
        } catch (Exception e) {
            DEBUG.error("Put value to redis fail...", e);
        }

        return false;
    }

    /**
     * 保存字符串到redis中
     */
    public static boolean setString(final String key, final String value) {
        // 如果redis 不需要 则直接返回
        if (!isNeedRedis) {
            return true;
        }
        String keyWithCC = getCCKey(key);
        try {
            return redisTemplate.execute((RedisCallback<Boolean>) redisConnection -> {
                redisConnection.set(redisTemplate.getStringSerializer().serialize(keyWithCC),
                        redisTemplate.getStringSerializer().serialize(value));
                return true;
            });
        } catch (Exception e) {
            DEBUG.error("putString value to redis fail...", e);
        }

        return false;
    }

    public static boolean hset(final String key, final String field, final String value) {
        // 如果redis 不需要 则直接返回
        if (!isNeedRedis) {
            return true;
        }
        String keyWithCC = getCCKey(key);

        try {
            return redisTemplate.execute(new RedisCallback<Boolean>() {
                @Override
                public Boolean doInRedis(RedisConnection redisConnection) throws DataAccessException {
                    return redisConnection.hSet(redisTemplate.getStringSerializer().serialize(keyWithCC),
                            redisTemplate.getStringSerializer().serialize(field),
                            redisTemplate.getStringSerializer().serialize(value));
                }
            });
        } catch (Exception e) {
            DEBUG.error("hset value to redis fail...", e);
        }

        return false;
    }

    public static boolean hsetPipeline(final String key, final List<RedisHsetBean> fieldValues) {
        // 如果redis 不需要 则直接返回
        if (!isNeedRedis) {
            return true;
        }
        String keyWithCC = getCCKey(key);
        try {
            return redisTemplate.execute(new RedisCallback<Boolean>() {
                @Override
                public Boolean doInRedis(RedisConnection redisConnection) throws DataAccessException {
                    redisConnection.openPipeline();
                    for (RedisHsetBean bean : fieldValues) {
                        redisConnection.hSet(redisTemplate.getStringSerializer().serialize(keyWithCC),
                                redisTemplate.getStringSerializer().serialize(bean.getField()),
                                redisTemplate.getStringSerializer().serialize(bean.getValue()));
                    }
                    List<Object> objects = redisConnection.closePipeline();
                    return !CollectionUtils.isEmpty(objects);
                }
            });
        } catch (Exception e) {
            DEBUG.error("hsetPipeline value to redis fail...", e);
        }

        return false;
    }

    public static String hget(final String key, final String field) {
        // 如果redis 不需要 则直接返回
        if (!isNeedRedis) {
            return null;
        }
        String keyWithCC = getCCKey(key);

        try {
            return redisTemplate.execute(new RedisCallback<String>() {
                @Override
                public String doInRedis(RedisConnection redisConnection) throws DataAccessException {
                    byte[] bytes = redisConnection.hGet(redisTemplate.getStringSerializer().serialize(keyWithCC),
                            redisTemplate.getStringSerializer().serialize(field));
                    return null != bytes ? redisTemplate.getStringSerializer().deserialize(bytes) : null;
                }
            });
        } catch (Exception e) {
            DEBUG.error("hget value from redis fail...", e);
        }

        return null;
    }

    /**
     * 从redis 中查询数据
     */
    public static Object get(final String key) {
        // 如果redis 不需要 则直接返回
        if (!isNeedRedis) {
            return null;
        }
        String keyWithCC = getCCKey(key);

        try {
            return redisTemplate.execute(new RedisCallback<Object>() {
                @Override
                public Object doInRedis(RedisConnection connection) throws DataAccessException {
                    return new JdkSerializationRedisSerializer().deserialize(connection.get(redisTemplate.getStringSerializer().serialize(keyWithCC)));
                }
            });
        } catch (Exception e) {
            DEBUG.error("Get value from  redis fail...", e);
        }
        return null;
    }

    /**
     * 从redis 中查询字符串对象
     */
    public static String getString(final String key) {
        // 如果redis 不需要 则直接返回
        if (!isNeedRedis) {
            return null;
        }
        String keyWithCC = getCCKey(key);

        try {
            return redisTemplate.execute((RedisCallback<String>) connection -> {
                byte[] bytes = connection.get(redisTemplate.getStringSerializer().serialize(keyWithCC));
                return null != bytes ? redisTemplate.getStringSerializer().deserialize(bytes) : null;
            });
        } catch (Exception e) {
            DEBUG.error("getString value from  redis fail...", e);
        }
        return null;
    }


    public static boolean hasKey(final String key) {
        // 如果redis 不需要 则直接返回
        if (!isNeedRedis) {
            return false;
        }
        String keyWithCC = getCCKey(key);

        return redisTemplate.hasKey(keyWithCC);

    }

    /**
     * 以毫秒为单位设置key的超时时间
     *
     * @param key        key
     * @param expireTime 超时时间
     * @return boolean
     */
    public static boolean expireByMilliseconds(String key, Long expireTime) {
        // 如果redis 不需要 则直接返回
        if (!isNeedRedis) {
            return false;
        }
        String keyWithCC = getCCKey(key);

        return redisTemplate.expire(keyWithCC, expireTime, TimeUnit.MILLISECONDS);
    }

    /**
     * 对存储在指定key的数值执行原子的加1操作
     *
     * @param key
     * @return
     */
    public static Long incrKey(String key) {
        if (!isNeedRedis) {
            return 1L;
        }
        String keyWithCC = getCCKey(key);

        return redisTemplate.execute((RedisCallback<Long>) connection ->
                connection.incr(redisTemplate.getStringSerializer().serialize(keyWithCC))
        );
    }

    /**
     * redis锁的应用
     * @param key
     * @param value
     * @return
     */
    public static boolean setnx(String key,String value){
        return redisTemplate.execute((RedisCallback<Boolean>) connection->connection.setNX(redisTemplate.getStringSerializer().serialize(key),value.getBytes(StandardCharsets.UTF_8)));
    }

    /**
     * 删除不带CC的key
     * @param key
     */
    public static void deleteWithoutCC(String key){
        try {
            redisTemplate.delete(key);
        } catch (Exception e) {
            DEBUG.error("deleteWithoutCC : " + key);
        }
    }
}
