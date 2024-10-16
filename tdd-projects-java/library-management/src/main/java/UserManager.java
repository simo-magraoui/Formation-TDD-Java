import com.library.repository.UserRepository;
import com.library.model.User;


public class UserManager {
    private UserRepository userRepository;
    private UserValidator userValidator;

    public UserManager(UserRepository userRepository, UserValidator userValidator) {
        this.userRepository = userRepository;
        this.userValidator = userValidator;
    }

    public void addUser(User user) {
        userValidator.validateUser(user);
        userRepository.save(user);
    }

    public void removeUser(User user) {
        userRepository.delete(user);
    }

    public void updateUser(User user) {
        userValidator.validateUser(user);
        userRepository.update(user);
    }

    public User findUserById(String id) {
        return userRepository.findById(id);
    }
}
