package com.liuhaidongcoder.guava;

import com.google.common.cache.Cache;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * @author Liu Haidong
 * @date 20/5/18
 */
public class LocalCacheService<K,V> implements ICacheService<K,V> {
    private Cache<K,V> kvCache;

    public LocalCacheService(Cache<K,V> cache) {
        this.kvCache = cache;
    }

    @Override
    public void put(K key, V value) {
        this.kvCache.put(key,value);
    }

    @Override
    public V getIfPresent(K key) {
        return this.kvCache.getIfPresent(key);
    }

    @Override
    public V getIfAbsent(K key, Callable<V> callable) throws ExecutionException {
        return this.kvCache.get(key,callable);
    }

    @Override
    public void invalidate(K key) {
        this.kvCache.invalidate(key);
    }
}
