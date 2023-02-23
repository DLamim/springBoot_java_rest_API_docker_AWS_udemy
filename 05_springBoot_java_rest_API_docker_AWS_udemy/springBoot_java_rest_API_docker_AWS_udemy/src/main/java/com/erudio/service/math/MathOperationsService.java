package com.erudio.service.math;

import org.springframework.web.bind.annotation.PathVariable;

public class MathOperationsService {

    public static Double sum(Double numberA, Double numberB) {
        return numberA + numberB;
    }

    public static Double subtraction(Double numberA, Double numberB) {
        return numberA - numberB;
    }

    public static Double division(Double numberA, Double numberB) {
        return numberA / numberB;
    }

    public static Double multiplication(Double numberA, Double numberB) {
        return numberA * numberB;
    }

    public static Double squareRoot(Double numberA) {
        return Math.sqrt(numberA);
    }
}
