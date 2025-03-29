package com.workouttracker.controller;

import org.springframework.web.bind.annotation.*;
import com.workouttracker.model.User;
import com.workouttracker.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        if (userService.getUserByUserame(user.getUsername()) != null) {
            return null;
        } else {
            return userService.saveUser(user);
        }
    }

    @PatchMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}