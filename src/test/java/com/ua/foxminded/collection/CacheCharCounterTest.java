package com.ua.foxminded.collection;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

class CacheCharCounterTest {

    private final CharCounter mock = Mockito.mock(CharCounter.class);
    private final CacheCharCounter charCounter = new CacheCharCounter(mock);

    @Test
    void count_shouldCountAmountInvocations_InvocationAmountGottaBeOneWhenStringsEqual() {
        when(mock.count("check")).thenReturn(new CalculationResult("check", new LinkedHashMap<>()));
        charCounter.count("check");
        charCounter.count("check");
        verify(mock, times(1)).count("check");
    }

    @Test
    void count_shouldCheckEqualityDecoratorCallAndMockCall() {
        CalculationResult expected = new CalculationResult("check", new LinkedHashMap<>());
        when(mock.count("check")).thenReturn(expected);
        assertSame(expected, charCounter.count("check"));
    }
}