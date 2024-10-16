package org.example.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class ExceptionTest {
    @Test
    void testException() {
        assertThrows(IllegalArgumentException.class, () -> {
            Integer.parseInt("One");
        }, "Un IllegalArgumentException doit être lancé pour 'One'");
    }
}