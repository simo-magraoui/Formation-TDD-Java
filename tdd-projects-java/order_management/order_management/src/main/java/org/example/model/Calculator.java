package org.example.model;

import org.example.service.MathService;

public class Calculator {
    private MathService mathService;

    public Calculator(MathService mathService) {
        this.mathService = mathService;
    }

    public int add(int a, int b) {
        return mathService.add(a, b);
    }

    public int divide(int a, int b) {
        return mathService.divide(a, b);
    }

}
