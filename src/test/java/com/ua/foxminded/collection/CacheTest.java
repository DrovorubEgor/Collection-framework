package com.ua.foxminded.collection;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CacheTest {

    private final CacheLoader<String, String> mock = Mockito.mock(CacheLoader.class);
    private Cache<String, String> cache;

    @BeforeEach
    void initialize() {
        when(mock.load(anyString())).then(returnsFirstArg());
        cache = new Cache<>(3, mock);
    }

    @Test
    void lookUp_shouldReturnSameInstance_whenSameArgumentsPassed () {
        when(mock.load(anyString())).thenAnswer(returnsFirstArg());
        String firstCall = cache.lookUp("check");
        String secondCall = cache.lookUp("check");
        assertSame(firstCall, secondCall);
    }

    @Test
    void lookUp_shouldCallLoadMethod_whenFirstTimeCalled() {
        cache.lookUp("check");
        verify(mock, Mockito.times(1)).load("check");
        verifyNoMoreInteractions(mock);
    }

    @Test
    void lookUp_shouldCallLoadOnce_whenArgumentsSame() {
        cache.lookUp("check");
        cache.lookUp("check");
        verify(mock, Mockito.times(1)).load("check");
        verifyNoMoreInteractions(mock);
    }

    @Test
    void lookUp_shouldCallLoadAgain_whenCacheOverflowed() {
        cache.lookUp("1");
        cache.lookUp("2");
        cache.lookUp("3");
        cache.lookUp("4");
        cache.lookUp("1");
        verify(mock, Mockito.times(2)).load("1");
    }

    @Test
    void lookUp_shouldCallLoadOnce_whenDifferentArgumentsPassed() {
        cache.lookUp("1");
        cache.lookUp("2");
        cache.lookUp("3");
        cache.lookUp("4");
        cache.lookUp("5");
        verify(mock, Mockito.times(1)).load("1");
        verify(mock, Mockito.times(1)).load("2");
        verify(mock, Mockito.times(1)).load("3");
        verify(mock, Mockito.times(1)).load("4");
        verify(mock, Mockito.times(1)).load("5");
    }
}