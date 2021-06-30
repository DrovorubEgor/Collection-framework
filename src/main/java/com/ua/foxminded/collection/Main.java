package com.ua.foxminded.collection;

public class Main {
    public static void main(String[] args) {
        CharCounter cacheCharCounter = new CacheCharCounter(new PlainCharCounter(), 3);
        System.out.println(cacheCharCounter.count("Hello world"));
        System.out.println(cacheCharCounter.count("Collection framework"));
        System.out.println(cacheCharCounter.count("War and peace"));
        System.out.println(cacheCharCounter.count("Atlas Shrugged"));
    }
}
