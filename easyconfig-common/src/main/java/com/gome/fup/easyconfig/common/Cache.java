package com.gome.fup.easyconfig.common;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by fupeng-ds on 2017/8/1.
 */
public class Cache {

    private final static Map<String, Object> cache = new ConcurrentHashMap<>();

    public static void put(String key, Object value) {
        cache.put(key, value);
    }

    public static Object get(String key) {
        return cache.get(key);
    }

    private Cache() {
    }
}
