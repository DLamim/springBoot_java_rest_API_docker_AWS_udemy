package com.erudio.controller;

import com.erudio.service.math.ConverterService;
import com.erudio.service.math.MathOperationsService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    @RequestMapping(value = "/sum/{numberA}/{numberB}", method = RequestMethod.GET)
    public Double sum(@PathVariable(value = "numberA") String numberA, @PathVariable(value = "numberB") String numberB) {
        return MathOperationsService.sum(ConverterService.convertToDouble(numberA), ConverterService.convertToDouble(numberB));
    }

    @RequestMapping(value = "/subtraction/{numberA}/{numberB}", method = RequestMethod.GET)
    public Double subtraction(@PathVariable(value = "numberA") String numberA, @PathVariable(value = "numberB") String numberB) {
        return MathOperationsService.subtraction(ConverterService.convertToDouble(numberA), ConverterService.convertToDouble(numberB));
    }

    @RequestMapping(value = "/division/{numberA}/{numberB}", method = RequestMethod.GET)
    public Double division(@PathVariable(value = "numberA") String numberA, @PathVariable(value = "numberB") String numberB) {
        return MathOperationsService.division(ConverterService.convertToDouble(numberA), ConverterService.convertToDouble(numberB));
    }

    @RequestMapping(value = "/multiplication/{numberA}/{numberB}", method = RequestMethod.GET)
    public Double multiplication(@PathVariable(value = "numberA") String numberA, @PathVariable(value = "numberB") String numberB) {
        return MathOperationsService.multiplication(ConverterService.convertToDouble(numberA), ConverterService.convertToDouble(numberB));
    }

    @RequestMapping(value = "/squareroot/{numberA}", method = RequestMethod.GET)
    public Double squareRoot(@PathVariable(value = "numberA") String numberA) {
        return MathOperationsService.squareRoot(ConverterService.convertToDouble(numberA));
    }


}
