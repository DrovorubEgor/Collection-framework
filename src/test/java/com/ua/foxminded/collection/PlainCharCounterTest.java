package com.ua.foxminded.collection;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PlainCharCounterTest {

    @Test
    void count_shouldCountInclusionEachChar_WhenEveryCharIncludedOnce() {
        final CalculationResult actual = new PlainCharCounter().count("Whats up");
        final Map<Character, Integer> map = new LinkedHashMap<>();
        map.put('W', 1);
        map.put('h', 1);
        map.put('a', 1);
        map.put('t', 1);
        map.put('s', 1);
        map.put(' ', 1);
        map.put('u', 1);
        map.put('p', 1);
        assertEquals(actual.getCounts(), map);
    }

    @Test
    void count_shouldCountInclusionEachChar_WhenSomeCharsIncludedMoreThanOnce() {
        final CalculationResult actual = new PlainCharCounter().count("War and peace");
        final Map<Character, Integer> map = new LinkedHashMap<>();
        map.put('W', 1);
        map.put('a', 3);
        map.put('r', 1);
        map.put(' ', 2);
        map.put('n', 1);
        map.put('d', 1);
        map.put('p', 1);
        map.put('e', 2);
        map.put('c', 1);
        assertEquals(actual.getCounts(), map);
    }

    @Test
    void count_shouldCountNothing_EmptyString() {
        final CalculationResult actual = new PlainCharCounter().count("");
        final Map<Character, Integer> map = new LinkedHashMap<>();
        assertEquals(actual.getCounts(), map);
    }

    @Test
    void count_shouldCountInclusionEachChar() {
        final CalculationResult actual = new PlainCharCounter().count(" ");
        final Map<Character, Integer> map = new LinkedHashMap<>();
        map.put(' ', 1);
        assertEquals(actual.getCounts(), map, "Should count each symbol when there is only one inclusion.");
    }

    @Test
    void count_shouldCountInclusionEachChar_WhenCharIncludedTwice() {
        final CalculationResult actual = new PlainCharCounter().count("  ");
        final Map<Character, Integer> map = new LinkedHashMap<>();
        map.put(' ', 2);
        assertEquals(actual.getCounts(), map, "Should count each symbol when some symbols are included several times.");
    }
}