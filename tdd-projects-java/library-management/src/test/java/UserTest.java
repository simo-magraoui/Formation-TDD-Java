import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class UserTest {
    @Test
    public void testUserCreation() {
        User user = new User("john_doe", "password123");
        assertEquals("john_doe", user.getUsername());
        assertEquals("password123", user.getPassword());
    }

    @Test
    public void testUserCreationWithNullUsername() {
        assertThrows(IllegalArgumentException.class, () -> {
            new User(null, "password123");
        });
    }
    @Test
    public void testUserCreationWithNullPassword() {
        assertThrows(IllegalArgumentException.class, () -> {
            new User("john_doe", null);
        });
    }

    @ParameterizedTest
    @CsvSource({
            "john_doe, password123, john_doe",
            "jane_doe, password321, jane_doe"
    })
    public void testParameterizedUserCreation(String username, String password, String expectedUsername) {
        User user = new User(username, password);
        assertEquals(expectedUsername, user.getUsername());
    }

    @Test
    public void testMatchers() {
        User user = new User("john_doe", "password123");
        assertThat(user.getUsername(), is("john_doe"));
        assertThat(user.getPassword(), is("password123"));
    }
}

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        if (username == null || password == null) {
            throw new IllegalArgumentException("Username and password cannot be null");
        }
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

