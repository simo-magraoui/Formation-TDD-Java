package org.example.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


import org.junit.jupiter.api.Test;

class MatcherTest {
    @Test
    void testMatchers() {
        assertThat(5, is(5));
        assertThat("Hello", startsWithIgnoringCase("h"));
        assertThat("Hello", endsWithIgnoringCase("O"));
        assertThat("Hello", containsStringIgnoringCase("Ell"));
    }
}
