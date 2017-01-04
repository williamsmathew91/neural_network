package com.lucidasoftware.neuralnetwork.util;

public class Calculus {

    public static double sigmoid(double x) {
        return (1/( 1 + Math.pow(Math.E,(-1*x))));
    }
}
