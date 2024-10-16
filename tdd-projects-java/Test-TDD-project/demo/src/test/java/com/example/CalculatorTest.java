package com.example;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;

//import ch.qos.logback.core.util.Duration;
import org.junit.jupiter.api.Test;


class CalculatorTest {

    @Test
    void testAdd() {
        Calculator calculator = new Calculator();
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    void testSubtract() {
        Calculator calculator = new Calculator();
        assertEquals(1, calculator.subtract(3, 2));
    }

    @Test
    void testMultiply() {
        Calculator calculator = new Calculator();
        assertEquals(6, calculator.multiply(2, 3));
    }

    @Test
    void testDivide() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.divide(6, 3));
    }

    @Test
    void testDivideByZero() {
        Calculator calculator = new Calculator();
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(6, 0);
        });
        assertEquals("Division by zero is not allowed", thrown.getMessage());
    }

    @Test
    void testDureeExecution() {
        Calculator calculator = new Calculator();
        int res = assertTimeout(Duration.ofMillis(1),
                () -> {return calculator.subtract(3, 2);});
        assertEquals(1, res);
    }
}