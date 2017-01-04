package com.lucidasoftware.neuralnetwork;

public class ValueAccumulator {

    private double value = 0;

    public void accum(double value) {
        this.value += value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
