package com.ua.foxminded.collection;

public abstract class CharCounterDecorator implements CharCounter {

    private final CharCounter charCounter;

    public CharCounterDecorator(CharCounter charCounter) {
        this.charCounter = charCounter;
    }

    @Override
    public CalculationResult count(String inputString) {
        return charCounter.count(inputString);
    }
}
