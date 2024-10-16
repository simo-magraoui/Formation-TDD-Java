package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class RectangleTest {
    @Test
    public void testCalculatePerimeter() {
        Rectangle rectangle = new Rectangle(2, 3);
        assertEquals(10, rectangle.calculatePerimeter());
    }

    @Test
    public void testCalculateArea() {
        Rectangle rectangle = new Rectangle(4, 5);
        assertEquals(20, rectangle.calculateArea());
    }

}
