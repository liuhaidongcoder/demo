package com.liuhaidongcoder.mybatis.cache;

import org.apache.ibatis.cache.Cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Liu Haidong
 * @date 20/12/10
 */
public class MyCustomCache implements Cache {
    private String id;
    private Map<Object,Object> objectObjectMap = new ConcurrentHashMap<>();
    public MyCustomCache(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void putObject(Object key, Object value) {
        objectObjectMap.put(key,value);
        System.out.println("key的值为: " + key );
        System.out.println("value的值为: " + value );
    }

    @Override
    public Object getObject(Object key) {
        System.out.println("get key :" + key);
        return objectObjectMap.get(key);
    }

    @Override
    public Object removeObject(Object key) {
        Object object = objectObjectMap.get(key);
        objectObjectMap.remove(key);
        return object;
    }

    @Override
    public void clear() {
        objectObjectMap.clear();
    }

    @Override
    public int getSize() {
        return objectObjectMap.size();
    }
}
