package com.workouttracker.service;

import com.workouttracker.model.User;
import com.workouttracker.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User getUserByUserame(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    public User updateUser(Long id, User updates) {
        return userRepository.findById(id).map(existingUser -> {
            if (updates.getUsername() != null) {
                existingUser.setUsername(updates.getUsername());
            }
            if (updates.getPassword() != null) {
                existingUser.setPassword(updates.getPassword());
            }
            return userRepository.save(existingUser);
        }).orElse(null);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}