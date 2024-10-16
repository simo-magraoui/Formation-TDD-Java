import com.library.model.User;

// SimpleUserValidator (Concrete Implementation)
public class SimpleUserValidator implements UserValidator {
    @Override
    public void validateUser(User user) {
        if (user.getName().isEmpty() || user.getEmail().isEmpty() || user.getPassword().isEmpty()) {
            return;
        }

        if (!isValidEmail(user.getEmail())) {
            return;
        }

        if (user.getPassword().length() < 8) {
        }

    }

    private boolean isValidEmail(String email) {
        // Implement email validation logic
        return true; // Replace with actual validation
    }
}
