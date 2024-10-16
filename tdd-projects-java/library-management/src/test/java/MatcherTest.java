import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;

public class MatcherTest {
    @Test
    public void testMatchers() {
        assertThat(5, is(5));
        assertThat("Hello", startsWith("H"));
        assertThat("Hello", endsWith("o"));
        assertThat("Hello", containsString("ell"));
    }
}
