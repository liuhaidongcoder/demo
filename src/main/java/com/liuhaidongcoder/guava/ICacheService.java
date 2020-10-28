package com.liuhaidongcoder.guava;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * @author Liu Haidong
 * @date 20/5/18
 */
public interface ICacheService<K,V> {
    void put(K k, V v);
    Object getIfPresent(K key);
    V getIfAbsent(K key, Callable<V> callable) throws ExecutionException;
    void invalidate(K key);
}
