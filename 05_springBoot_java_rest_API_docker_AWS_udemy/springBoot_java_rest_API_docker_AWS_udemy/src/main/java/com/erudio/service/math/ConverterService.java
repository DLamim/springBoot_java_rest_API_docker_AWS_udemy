package com.erudio.service.math;

import com.erudio.exceptions.UnsupportedMathOperationException;

public class ConverterService {

    public static Double convertToDouble(String strNumber) {
        String number = process(strNumber);
        return Double.parseDouble(number);
    }

    private static boolean isNumeric(String strNumber) {
        return strNumber.matches("[+-]?[0-9]*\\.?[0-9]+");
    }

    private static String process(String strNumber) {
        String number = strNumber.replaceAll(",", ".");

        if (number.isEmpty() || !isNumeric(number)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }

        return number;
    }
}
