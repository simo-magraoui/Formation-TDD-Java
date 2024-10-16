package org.example.service;

import static org.mockito.Mockito.*;

import org.mockito.Mock;
import org.mockito.exceptions.base.MockitoException;
import org.example.model.Calculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @Test
    void testAdd() {
        MathService mockMathService = mock(MathService.class);
        when(mockMathService.add(2, 3)).thenReturn(5);

        Calculator calculator = new Calculator(mockMathService);
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    void testDevide() {
        MathService mockMathService = mock(MathService.class);
        when(mockMathService.divide(6, 3)).thenReturn(2);

        Calculator calculator = new Calculator(mockMathService);
        assertEquals(2, calculator.divide(6, 3));
    }

    @Mock
    MathService mockMathService;

    @Test
    void testDividebyZero() {
        mockMathService = mock(MathService.class);
        when(mockMathService.divide(10, 0)).thenThrow(new ArithmeticException("Cannot divide by zero"));
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> mockMathService.divide(10, 0));
        System.out.println(exception.getMessage());
    }
}
