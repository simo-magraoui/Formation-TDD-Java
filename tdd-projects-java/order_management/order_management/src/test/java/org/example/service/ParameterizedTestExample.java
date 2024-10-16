package org.example.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ParameterizedTestExample {
    @ParameterizedTest
    @CsvSource({
            "2, 3, 5",
            "3, 7, 10",
            "5, 5, 10",
            "20, 30, 50"
    })
    void testAdd(int a, int b, int expected) {
        Calculator calculator = new Calculator();
        assertEquals(expected, calculator.add(a, b));
    }
}

class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}
