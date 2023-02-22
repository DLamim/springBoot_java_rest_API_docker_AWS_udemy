package com.erudio.controller;

import com.erudio.exeptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    @RequestMapping(value = "/sum/{numberA}/{numberB}", method = RequestMethod.GET)
    public Double sum(@PathVariable(value = "numberA") String numberA, @PathVariable(value = "numberB") String numberB) {
        return convertToDouble(numberA) + convertToDouble(numberB);
    }

    @RequestMapping(value = "/subtraction/{numberA}/{numberB}", method = RequestMethod.GET)
    public Double subtraction(@PathVariable(value = "numberA") String numberA, @PathVariable(value = "numberB") String numberB) {
        return convertToDouble(numberA) - convertToDouble(numberB);
    }

    @RequestMapping(value = "/division/{numberA}/{numberB}", method = RequestMethod.GET)
    public Double division(@PathVariable(value = "numberA") String numberA, @PathVariable(value = "numberB") String numberB) {
        return convertToDouble(numberA) / convertToDouble(numberB);
    }

    @RequestMapping(value = "/multiplication/{numberA}/{numberB}", method = RequestMethod.GET)
    public Double multiplication(@PathVariable(value = "numberA") String numberA, @PathVariable(value = "numberB") String numberB) {
        return convertToDouble(numberA) * convertToDouble(numberB);
    }

    @RequestMapping(value = "/squareroot/{numberA}", method = RequestMethod.GET)
    public Double squareRoot(@PathVariable(value = "numberA") String numberA) {
        return Math.sqrt(convertToDouble(numberA));
    }

    private Double convertToDouble(String strNumber) {
        String number = process(strNumber);
        return Double.parseDouble(number);
    }

    private boolean isNumeric(String strNumber) {
        return strNumber.matches("[+-]?[0-9]*\\.?[0-9]+");
    }

    private String process(String strNumber) {
        String number = strNumber.replaceAll(",", ".");

        if (number.isEmpty() || !isNumeric(number)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }

        return number;
    }
}
