package com.ua.foxminded.collection;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cache<K, V> {

    private final Map<K, V> cachedData;
    private final CacheLoader<K, V> cacheLoader;

    public Cache(final int size, CacheLoader<K, V> cacheLoader) {
        cachedData = new LinkedHashMap<K, V>(size, 0.75f, false) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > size;
            }
        };
        this.cacheLoader = cacheLoader;
    }

    public V lookUp(K key) {
        return cachedData.computeIfAbsent(key, cacheLoader::load);
    }
}
