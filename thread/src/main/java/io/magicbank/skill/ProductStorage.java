package io.magicbank.skill;

import redis.clients.jedis.Jedis;

public class ProductStorage {
    public static final int count = 2;
    public static final String PRODUCT_1_STORAGE = "product:1:storage";

    public Boolean descStorage(){
        // 库存在redis是否存在
        Jedis jedis = RedisUtil.getJedis();
        String s = jedis.get(PRODUCT_1_STORAGE);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Long desc = 0L;
        if(s == null){
            synchronized (this){
                if(jedis.get(PRODUCT_1_STORAGE)==null){
                    jedis.setex(PRODUCT_1_STORAGE, 10, String.valueOf(count));
                    Long decr = jedis.decr(PRODUCT_1_STORAGE);
                    RedisUtil.returnResource(jedis);
                    return true;
                }
            }
        }

        synchronized (this) {
            // 有值判断>0
            if (Integer.valueOf(jedis.get(PRODUCT_1_STORAGE)) > 0) {
                Long decr = jedis.decr(PRODUCT_1_STORAGE);
                RedisUtil.returnResource(jedis);
                return true;
            }
        }

        RedisUtil.returnResource(jedis);
        return false;
    }
}
