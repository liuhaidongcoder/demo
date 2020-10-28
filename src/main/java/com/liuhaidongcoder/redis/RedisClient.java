package com.liuhaidongcoder.redis;

import redis.clients.jedis.*;
import redis.clients.jedis.params.SetParams;
import redis.clients.jedis.util.JedisClusterCRC16;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @author Liu Haidong
 * @date 20/6/30
 */
public class RedisClient {
    private static ExecutorService executorService = Executors.newCachedThreadPool();
    public static void main(String[] args) {
        Set<HostAndPort> hostAndPorts = new HashSet<>();
        Arrays.stream("".split(",")).forEach(host->{
            hostAndPorts.add(HostAndPort.parseString(host));
        });
        JedisCluster jedisCluster = new JedisCluster(hostAndPorts, new JedisPoolConfig());

       // test(jedisCluster);
       // testString(jedisCluster);
       // testNumber(jedisCluster);
       // testList(jedisCluster);
      //  testHash(jedisCluster);
      //  testSortedSet(jedisCluster);
        consumer(jedisCluster);

    }
    public static void consumer(JedisCluster jedisCluster){


        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while(true){
                    jedisCluster.subscribe(new JedisPubSub() {
                        @Override
                        public void onMessage(String channel, String message) {
                            System.out.println("1"+message);
                            super.onMessage(channel, message);
                        }

                        @Override
                        public void onUnsubscribe(String channel, int subscribedChannels) {
                            super.onUnsubscribe(channel, subscribedChannels);
                        }

                        @Override
                        public void onSubscribe(String channel, int subscribedChannels) {
                            super.onSubscribe(channel, subscribedChannels);
                        }
                    },"redisChat");
                }
            }
        } ;
        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                while(true){
                    jedisCluster.subscribe(new JedisPubSub() {
                        @Override
                        public void onMessage(String channel, String message) {
                            System.out.println("管道:"+channel+",消息:"+message);
                            super.onMessage(channel, message);
                        }

                        @Override
                        public void onUnsubscribe(String channel, int subscribedChannels) {
                            super.onUnsubscribe(channel, subscribedChannels);
                        }

                        @Override
                        public void onSubscribe(String channel, int subscribedChannels) {
                            super.onSubscribe(channel, subscribedChannels);
                        }
                    },"redisChat","redisChat4");
                }
            }
        } ;
        executorService.submit(runnable);
        executorService.submit(runnable2);

    }
    public static void test(JedisCluster jedisCluster){
        System.out.println("判断key是否存在:" + jedisCluster.exists("key"));
        System.out.println("新增<'key','value'>的键值对:"+jedisCluster.set("key", "value"));
        System.out.println("判断key是否存在:"+jedisCluster.exists("key"));
        System.out.println("删除key:" + jedisCluster.del("key"));
        System.out.println("判断key是否存在:"+jedisCluster.exists("key"));
        System.out.println("新增<'key','value'>的键值对:"+jedisCluster.set("key", "value"));
        System.out.println("设置key的过期时间:"+jedisCluster.expire("key",10));
        System.out.println("设置key的过期时间点:" + jedisCluster.expireAt("key",1597030200));
        System.out.println("查看key的剩余时间:" + jedisCluster.ttl("key"));
        System.out.println("移除key的剩余时间:" + jedisCluster.persist("key"));
        System.out.println("查看key所存储的值类型:" + jedisCluster.type("key"));
    }
    public static void testString(JedisCluster jedisCluster){

        System.out.println("===========增加数据===========");
        System.out.println(jedisCluster.set("key1","value1"));
        System.out.println(jedisCluster.set("key2","value2"));
        System.out.println(jedisCluster.set("key3", "value3"));

        System.out.println("删除键key2:"+jedisCluster.del("key2"));
        System.out.println("获取键key2:"+jedisCluster.get("key2"));

        System.out.println("修改key1:"+jedisCluster.set("key1", "value1Changed"));
        System.out.println("获取key1的值："+jedisCluster.get("key1"));
        System.out.println("在key3后面加入值："+jedisCluster.append("key3", "End"));
        System.out.println("key3的值："+jedisCluster.get("key3"));

        //命令的时候才会去连接连接，集群中连接是对一个节点连接，不能判断多个key经过crc16算法所对应的槽在一个节点上，不支持多key获取、删除
        //System.out.println("增加多个键值对："+jedis.mset("key01","value01","key02","value02"));
        //System.out.println("获取多个键值对："+jedis.mget("key01","key02","key03"));
        //System.out.println("获取多个键值对："+jedis.mget("key01","key02","key03","key04"));
        //System.out.println("删除多个键值对："+jedis.del(new String[]{"key01","key02"}));
        //System.out.println("获取多个键值对："+jedis.mget("key01","key02","key03"));

        //jedis.flushDB();
        System.out.println("===========新增键值对防止覆盖原先值==============");
        System.out.println(jedisCluster.setnx("key1", "value1"));
        System.out.println(jedisCluster.setnx("key2", "value2"));
        System.out.println(jedisCluster.setnx("key2", "value2-new"));
        System.out.println(jedisCluster.get("key1"));
        System.out.println(jedisCluster.get("key2"));

        System.out.println("===========新增键值对并设置有效时间=============");
        System.out.println(jedisCluster.setex("key3", 2, "value3"));
        System.out.println(jedisCluster.get("key3"));
        System.out.println(jedisCluster.get("key3"));

        System.out.println("===========获取原值，更新为新值==========");
        System.out.println(jedisCluster.getSet("key2", "key2GetSet"));
        System.out.println(jedisCluster.get("key2"));
        System.out.println("获得key2的值的字串："+jedisCluster.getrange("key2", 2, 4));
    }
    public static void testNumber(JedisCluster jedisCluster){

        jedisCluster.set("key1", "1");
        jedisCluster.set("key2", "2");
        jedisCluster.set("key3", "2.3");
        System.out.println("key1的值："+jedisCluster.get("key1"));
        System.out.println("key2的值："+jedisCluster.get("key2"));
        System.out.println("key1的值加1："+jedisCluster.incr("key1"));
        System.out.println("获取key1的值："+jedisCluster.get("key1"));
        System.out.println("key2的值减1："+jedisCluster.decr("key2"));
        System.out.println("获取key2的值："+jedisCluster.get("key2"));
        System.out.println("将key1的值加上整数5："+jedisCluster.incrBy("key1", 5));
        System.out.println("获取key1的值："+jedisCluster.get("key1"));
        System.out.println("将key2的值减去整数5："+jedisCluster.decrBy("key2", 5));
        System.out.println("获取key2的值："+jedisCluster.get("key2"));
        System.out.println("key3的值："+jedisCluster.get("key3"));

    }

    public static void testList(JedisCluster jedisCluster){
        System.out.println("===========添加一个list===========");
        jedisCluster.lpush("collections", "ArrayList", "Vector", "Stack", "HashMap", "WeakHashMap", "LinkedHashMap");
        jedisCluster.lpush("collections", "HashSet");
        jedisCluster.lpush("collections", "TreeSet");
        jedisCluster.lpush("collections", "TreeMap");

        //-1代表倒数第一个元素，-2代表倒数第二个元素
        System.out.println("collections的内容："+jedisCluster.lrange("collections", 0, -1));
        // 前面4个值
        System.out.println("collections区间0-3的元素："+jedisCluster.lrange("collections",0,3));
        System.out.println("===============================");
        // 删除列表指定的值 ，第二个参数为删除的个数（有重复时），后add进去的值先被删，类似于出栈
        System.out.println("删除指定元素个数："+jedisCluster.lrem("collections", 2, "HashMap"));
        System.out.println("collections的内容："+jedisCluster.lrange("collections", 0, -1));


        System.out.println("删除下标0-3区间之外的元素："+jedisCluster.ltrim("collections", 0, 3));
        System.out.println("collections的内容："+jedisCluster.lrange("collections", 0, -1));

        System.out.println("collections列表出栈（左端）："+jedisCluster.lpop("collections"));
        System.out.println("collections的内容："+jedisCluster.lrange("collections", 0, -1));

        System.out.println("collections添加元素，从列表右端，与lpush相对应："+jedisCluster.rpush("collections", "EnumMap"));
        System.out.println("collections的内容："+jedisCluster.lrange("collections", 0, -1));

        System.out.println("collections列表出栈（右端）："+jedisCluster.rpop("collections"));
        System.out.println("collections的内容："+jedisCluster.lrange("collections", 0, -1));

        System.out.println("修改collections指定下标1的内容："+jedisCluster.lset("collections", 1, "LinkedArrayList"));
        System.out.println("collections的内容："+jedisCluster.lrange("collections", 0, -1));
        System.out.println("===============================");
        System.out.println("collections的长度："+jedisCluster.llen("collections"));
        System.out.println("获取collections下标为2的元素："+jedisCluster.lindex("collections", 2));
        System.out.println("===============================");
        jedisCluster.lpush("sortedList", "3","6","2","0","7","4");
        System.out.println("sortedList排序前："+jedisCluster.lrange("sortedList", 0, -1));
        System.out.println(jedisCluster.sort("sortedList"));
        System.out.println("sortedList排序后："+jedisCluster.lrange("sortedList", 0, -1));
    }

    public void testSet(JedisCluster jedisCluster) {
        System.out.println("============向集合中添加元素============");
        System.out.println(jedisCluster.sadd("eleSet", "e1","e2","e4","e3","e0","e8","e7","e5"));
        System.out.println(jedisCluster.sadd("eleSet", "e6"));
        System.out.println(jedisCluster.sadd("eleSet", "e6")); // 返回0，集合中已经存在
        System.out.println("eleSet的所有元素为："+jedisCluster.smembers("eleSet"));
        System.out.println("删除一个元素e0："+jedisCluster.srem("eleSet", "e0"));
        System.out.println("eleSet的所有元素为："+jedisCluster.smembers("eleSet"));
        System.out.println("删除两个元素e7和e6："+jedisCluster.srem("eleSet", "e7","e6"));
        System.out.println("eleSet的所有元素为："+jedisCluster.smembers("eleSet"));
        System.out.println("随机的移除集合中的一个元素："+jedisCluster.spop("eleSet"));
        System.out.println("随机的移除集合中的一个元素："+jedisCluster.spop("eleSet"));
        System.out.println("eleSet的所有元素为："+jedisCluster.smembers("eleSet"));
        System.out.println("eleSet中包含元素的个数："+jedisCluster.scard("eleSet"));
        System.out.println("e3是否在eleSet中："+jedisCluster.sismember("eleSet", "e3"));
        System.out.println("e1是否在eleSet中："+jedisCluster.sismember("eleSet", "e1"));
        System.out.println("e5是否在eleSet中："+jedisCluster.sismember("eleSet", "e5"));

        // 集群下并存会报错：redis.clients.jedis.exceptions.JedisClusterException: No way to dispatch this command to Redis Cluster because keys have different slots.
        // Redis集群，从key1集合与key2集合并存、交集、差集，两个键经过crc16算法可能有不同的槽。
        /*System.out.println("=================================");
        System.out.println(jedis.sadd("eleSet1", "e1","e2","e4","e3","e0","e8","e7","e5"));
        System.out.println(jedis.sadd("eleSet2", "e1","e2","e4","e3","e0","e8"));
        System.out.println("将eleSet1中删除e1并存入eleSet3中："+jedis.smove("eleSet1", "eleSet3", "e1"));
        System.out.println("将eleSet1中删除e2并存入eleSet3中："+jedis.smove("eleSet1", "eleSet3", "e2"));
        System.out.println("eleSet1中的元素："+jedis.smembers("eleSet1"));
        System.out.println("eleSet3中的元素："+jedis.smembers("eleSet3"));*/

        /*System.out.println("============集合运算=================");
        System.out.println("eleSet1中的元素："+jedis.smembers("eleSet1"));
        System.out.println("eleSet2中的元素："+jedis.smembers("eleSet2"));
        System.out.println("eleSet1和eleSet2的交集:"+jedis.sinter("eleSet1","eleSet2"));
        System.out.println("eleSet1和eleSet2的并集:"+jedis.sunion("eleSet1","eleSet2"));
        System.out.println("eleSet1和eleSet2的差集:"+jedis.sdiff("eleSet1","eleSet2"));*/
        jedisCluster.del("eleSet");
        jedisCluster.del("eleSet1");
        jedisCluster.del("eleSet2");
        jedisCluster.del("eleSet3");
    }

    public static void testHash(JedisCluster jedisCluster){
        Map<String,String> map = new HashMap<String,String>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
        map.put("key4","value4");
        jedisCluster.hmset("hash",map);
        jedisCluster.hset("hash", "key5", "value5");
        //return Map<String,String>
        System.out.println("散列hash的所有键值对为："+jedisCluster.hgetAll("hash"));
        //return Set<String>
        System.out.println("散列hash的所有键为："+jedisCluster.hkeys("hash"));
        //return List<String>
        System.out.println("散列hash的所有值为："+jedisCluster.hvals("hash"));
        System.out.println("将key6保存的值加上一个整数，如果key6不存在则添加key6："+jedisCluster.hincrBy("hash", "key6", 6));
        System.out.println("散列hash的所有键值对为："+jedisCluster.hgetAll("hash"));
        System.out.println("将key6保存的值加上一个整数，如果key6不存在则添加key6："+jedisCluster.hincrBy("hash", "key6", 3));
        System.out.println("散列hash的所有键值对为："+jedisCluster.hgetAll("hash"));
        System.out.println("删除一个或者多个键值对："+jedisCluster.hdel("hash", "key2"));
        System.out.println("散列hash的所有键值对为："+jedisCluster.hgetAll("hash"));
        System.out.println("散列hash中键值对的个数："+jedisCluster.hlen("hash"));
        System.out.println("判断hash中是否存在key2："+jedisCluster.hexists("hash","key2"));
        System.out.println("判断hash中是否存在key3："+jedisCluster.hexists("hash","key3"));
        System.out.println("获取hash中的值："+jedisCluster.hmget("hash","key3"));
        System.out.println("获取hash中的值："+jedisCluster.hmget("hash","key3","key4"));

    }

    public static  void testSortedSet(JedisCluster jedisCluster){
        Map<String,Double> map = new HashMap<String,Double>();
        map.put("key2",1.2);
        map.put("key3",4.0);
        map.put("key4",5.0);
        map.put("key5",0.2);
        // 将一个或多个 member 元素及其 score 值加入到有序集 key 当中，如果某个 member 已经是有序集的成员，那么更新这个 member 的 score 值
        // score 值可以是整数值或双精度浮点数
        System.out.println(jedisCluster.zadd("zset", 3,"key1"));
        System.out.println(jedisCluster.zadd("zset",map));
        System.out.println("zset中的所有元素："+jedisCluster.zrange("zset", 0, -1));

        System.out.println("zset中的所有元素："+jedisCluster.zrangeWithScores("zset", 0, -1));
        System.out.println("zset中的所有元素："+jedisCluster.zrangeByScore("zset", 0,10));

        System.out.println("zset中的所有元素："+jedisCluster.zrangeByScoreWithScores("zset", 0,100));
        System.out.println("zset中key2的分值："+jedisCluster.zscore("zset", "key2"));
        System.out.println("zset中key2的排名："+jedisCluster.zrank("zset", "key2"));
        System.out.println("删除zset中的元素key3："+jedisCluster.zrem("zset", "key3"));
        System.out.println("zset中的所有元素："+jedisCluster.zrange("zset", 0, -1));
        System.out.println("zset中元素的个数："+jedisCluster.zcard("zset"));
        System.out.println("zset中分值在1-4之间的元素的个数："+jedisCluster.zcount("zset", 1, 4));
        System.out.println("key2的分值加上5："+jedisCluster.zincrby("zset", 5, "key2"));
        System.out.println("key3的分值加上4："+jedisCluster.zincrby("zset", 4, "key3"));
        System.out.println("zset中的所有元素："+jedisCluster.zrange("zset", 0, -1));
    }
}
