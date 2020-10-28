package com.liuhaidongcoder.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Maps;

import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author Liu Haidong
 * @date 20/5/18
 */
public class CacheServiceProvider {

    public static enum CacheServiceEnum{
        CACHE_SERVICE_ID_MAP(""),CACHE_SERVICE_AUTH("");

        public String getName() {
            return name;
        }

        public String name;

        CacheServiceEnum(String name) {
            this.name = name;
        }
    }
    private static volatile CacheServiceProvider cacheService = null;
    private  Map<String,ICacheService> cacheLocalMap = Maps.newConcurrentMap();
    private  Map<String,ICacheService> cacheRemoteMap = Maps.newConcurrentMap();
    private CacheServiceProvider() {
        initLocalCacheMap();
        initRemoteCacheMap();
    }

    private void initLocalCacheMap(){
       // Cache<String,String> cache = CacheBuilder.newBuilder().initialCapacity(1).maximumSize(2).recordStats().expireAfterWrite(10, TimeUnit.SECONDS).build();

        LoadingCache<String,String> cache = CacheBuilder.newBuilder()
                .maximumSize(7)
                .expireAfterWrite(10, TimeUnit.SECONDS)
                .weakKeys()
                .build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String s) throws Exception {
                        return "hello " + s;
                    }
                });
        cacheLocalMap.put(CacheServiceEnum.CACHE_SERVICE_ID_MAP.getName(),new LocalCacheService<>(cache));
    }
    private void initRemoteCacheMap(){
        cacheRemoteMap.put(CacheServiceEnum.CACHE_SERVICE_ID_MAP.getName(),new RemoteCacheService<String,String>());
    }
    public static CacheServiceProvider getInstance(){
        if(null == cacheService){
            synchronized (CacheServiceProvider.class){
                if(null == cacheService){
                    cacheService = new CacheServiceProvider();
                }
            }
        }
        return cacheService;
    }

    public  <K,V> ICacheService<K,V> getLocalCacheService(CacheServiceEnum cacheServiceEnum){
       return cacheLocalMap.get(cacheServiceEnum.getName());
    }

    public  <K,V> ICacheService<K,V> getRemoteCacheService(CacheServiceEnum cacheServiceEnum){
        return cacheRemoteMap.get(cacheServiceEnum.getName());
    }

    public static void main(String[] args) throws ExecutionException {
        ICacheService<String,String> iCacheService = CacheServiceProvider.getInstance().getLocalCacheService(CacheServiceEnum.CACHE_SERVICE_AUTH);
        iCacheService.put("name","liuhaidong");
        iCacheService.put("key","value");
        iCacheService.put("key3","value3");
        while(true){
            iCacheService.invalidate("key");
            System.out.println(iCacheService.getIfPresent("name"));
            System.out.println(iCacheService.getIfPresent("key"));
            System.out.println(iCacheService.getIfPresent("key3"));
        }

    }
}
