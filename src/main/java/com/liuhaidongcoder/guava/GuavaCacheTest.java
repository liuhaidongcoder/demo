package com.liuhaidongcoder.guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.*;

/**
 * @author Liu Haidong
 * @date 20/5/18
 */
public class GuavaCacheTest {
    public static void main(String[] args) throws ExecutionException {
       final Cache<String,String> cache = CacheBuilder.newBuilder()
                .maximumSize(10)
                .expireAfterWrite(5, TimeUnit.SECONDS)
                .concurrencyLevel(10).build();

        while(true){
            System.out.println(cache.get("key", new Callable<String>() {
               @Override
               public String call() throws Exception {
                   cache.put("key","helloworld");
                   return cache.getIfPresent("key");
               }
           }));
        }

    }
}
