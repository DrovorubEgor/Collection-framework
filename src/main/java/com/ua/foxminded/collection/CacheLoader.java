package com.ua.foxminded.collection;

@FunctionalInterface
public interface CacheLoader<K, V> {
    V load(K key);
}
