package org.example.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AssertionTest {
    @Test
    void testAssertions() {
        assertEquals(5, 2 + 3, "2 + 3 doit être égal à 5");
        assertTrue("Hello".startsWith("H"), "'Hello' doit commencer par 'H'");
        assertFalse("Hello".endsWith("A"), "'Hello' ne doit pas se terminer par 'A'");
    }
}
