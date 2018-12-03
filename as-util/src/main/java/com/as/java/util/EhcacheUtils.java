package com.as.java.util;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import java.util.Optional;

/**
 * @author as
 * @since 2018/11/27 12:05
 */
public class EhcacheUtils {

    private static Cache cache;
    static{
        CacheManager cacheManager = CacheManager.create(
                EhcacheUtils.class.getResource("/ehcache.xml"));
        final String cacheName = "as-cache";
        cacheManager.addCache(cacheName);
        cache = cacheManager.getCache(cacheName);
    }

    public static void put(String key, Object value) {
        cache.put(new Element(key, value));
    }

    public static void remove(String key) {
        cache.remove(key);
    }

    public static Object get(String key) {
        return Optional.ofNullable(cache.get(key)).map(Element::getObjectValue).orElse(null);
    }
}
