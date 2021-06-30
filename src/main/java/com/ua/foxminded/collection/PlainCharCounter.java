package com.ua.foxminded.collection;

import java.util.LinkedHashMap;
import java.util.Map;

public class PlainCharCounter implements CharCounter {

    @Override
    public CalculationResult count(String inputString) {
        Map<Character, Integer> resultMap = new LinkedHashMap<>();
        for (char symbol : inputString.toCharArray()) {
            resultMap.merge(symbol, 1, (oldValue, newValue) -> oldValue + 1);
        }
        return new CalculationResult(inputString, resultMap);
    }
}
