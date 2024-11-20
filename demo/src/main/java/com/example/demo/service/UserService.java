package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Създаване на потребител
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Намиране на потребител по ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Намиране на потребител по имейл
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Актуализация на потребител
    public User updateUser(Long id, User updatedUser) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setName(updatedUser.getName());
                    user.setEmail(updatedUser.getEmail());
                    user.setPhone(updatedUser.getPhone());
                    user.setPassword(updatedUser.getPassword());
                    return userRepository.save(user);
                })
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    // Изтриване на потребител
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
