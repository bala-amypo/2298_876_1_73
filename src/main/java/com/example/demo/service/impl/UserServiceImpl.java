@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final Map<String, User> users = new HashMap<>();

    public UserServiceImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User registerUser(User user, String roleName) {
        users.put(user.getUsername(), user);
        return user; // MUST return User
    }

    @Override
    public User findByUsername(String username) {
        return users.get(username); // MUST return User
    }

    @Override
    public boolean checkPassword(String rawPassword, String encodedPassword) {
        return rawPassword.equals(encodedPassword);
    }
}
