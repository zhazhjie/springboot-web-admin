package com.web.admin.shiro;

import org.apache.shiro.cache.CacheException;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

import java.util.Collection;
import java.util.Set;

/**
 * shiro_redis缓存
 *
 * @param <K>
 * @param <V>
 */

public class ShiroCache<K, V> implements org.apache.shiro.cache.Cache<K, V> {

    private String hashKey = "shiro:cache";

    private Cache cache;

    private CacheManager cacheManager;

    public ShiroCache(CacheManager cacheManager,String name) {
        if(name==null || cacheManager==null){
            throw new IllegalArgumentException("cacheManager or CacheName cannot be null.");
        }
        this.cacheManager=cacheManager;
        this.cache = cacheManager.getCache(name);
    }

    @Override
    public V get(K key) throws CacheException {
        if(key == null){
            return null;
        }
        Cache.ValueWrapper valueWrapper = cache.get(key);
        if(valueWrapper==null){
            return null;
        }
        return (V) valueWrapper.get();
    }

    @Override
    public V put(K key, V value) throws CacheException {
        cache.put(key, value);
        return get(key);
    }

    @Override
    public V remove(K key) throws CacheException {
        V v = get(key);
        cache.evict(key);
        return v;
    }

    @Override
    public void clear() throws CacheException {
        cache.clear();
    }

    @Override
    public int size() {
        return cacheManager.getCacheNames().size();
    }

    /**
     * 获取缓存中所的key值
     */
    @Override
    public Set<K> keys() {
        return (Set<K>) cacheManager.getCacheNames();
    }

    /**
     * 获取缓存中所有的values值
     */
    @Override
    public Collection<V> values() {
        return (Collection<V>) cache.get(cacheManager.getCacheNames()).get();
    }

    @Override
    public String toString() {
        return "ShiroSpringCache [cache=" + cache + "]";
    }
}
