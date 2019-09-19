package com.web.admin.config;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.util.Destroyable;

public class ShiroCacheManager implements CacheManager ,Destroyable{

    private org.springframework.cache.CacheManager cacheManager;

    private ShiroCache shiroCache;

    public org.springframework.cache.CacheManager getCacheManager() {
        return cacheManager;
    }

    public void setCacheManager(org.springframework.cache.CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    @Override
    public void destroy() throws Exception {
        cacheManager = null;
    }

    @Override
    public <K, V> Cache<K, V> getCache(String name)  {
        if (name == null ){
            return null;
        }
        ShiroCache<K, V> shiroCache = new ShiroCache<>(cacheManager, name);
        this.shiroCache=shiroCache;
        return shiroCache;
    }

    public Object remove(Object key){
        return this.shiroCache.remove(key);
    }
}