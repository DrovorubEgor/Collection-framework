package com.ua.foxminded.collection;

import java.util.Collections;
import java.util.Map;

public class CalculationResult {

    private final String inputString;
    private final Map<Character, Integer> charactersAmount;

    public CalculationResult(String inputString, Map<Character, Integer> charactersAmount) {
        this.inputString = inputString;
        this.charactersAmount = charactersAmount;
    }

    public Map<Character, Integer> getCounts() {
        return Collections.unmodifiableMap(charactersAmount);
    }

    @Override
    public String toString() {
        StringBuilder resultString = new StringBuilder(inputString + System.lineSeparator());
        charactersAmount.forEach((key, value) -> resultString.append("\"")
                .append(key)
                .append("\" - ")
                .append(value)
                .append(System.lineSeparator()));
        return resultString.toString();
    }
}
