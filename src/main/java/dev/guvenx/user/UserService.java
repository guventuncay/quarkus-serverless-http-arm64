package dev.guvenx.user;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class UserService {

    @Inject
    UserRepository userRepository;

    public void createUser(String name, String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);

        userRepository.saveUser(user);
    }

    public User getUser(String userId) {
        return userRepository.getUserById(userId);
    }

    public User updateUser(String userId, User user) {
        user.setUserId(userId);
        return userRepository.updateUser(user);
    }

    public void removeUser(String userId) {
        userRepository.deleteUser(userId);
    }

    public List<User> getAll() {
        return userRepository.getAllUsers();
    }
}
