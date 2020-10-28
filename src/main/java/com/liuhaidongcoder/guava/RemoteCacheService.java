package com.liuhaidongcoder.guava;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * @author Liu Haidong
 * @date 20/5/18
 */
public class RemoteCacheService<K,V> implements ICacheService<K,V> {

    @Override
    public void put(K key, V value) {
    }

    @Override
    public V getIfPresent(K key) {
        return null;
    }

    @Override
    public V getIfAbsent(K key, Callable<V> callable) throws ExecutionException {
        return null;
    }

    @Override
    public void invalidate(K key) {

    }
}
