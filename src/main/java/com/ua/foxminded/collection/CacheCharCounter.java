package com.ua.foxminded.collection;

public class CacheCharCounter extends CharCounterDecorator {

    private final Cache<String, CalculationResult> cache;
    private static final int INITIAL_SIZE = 3;

    public CacheCharCounter(CharCounter charCounter, final int cacheSize) {
        super(charCounter);
        cache = new Cache<>(cacheSize, super::count);
    }

    public CacheCharCounter(CharCounter charCounter) {
        this(charCounter, INITIAL_SIZE);
    }

    @Override
    public CalculationResult count(String inputString) {
        return cache.lookUp(inputString);
    }
}
