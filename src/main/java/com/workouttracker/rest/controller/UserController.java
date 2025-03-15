package com.workouttracker.rest.controller;

import org.springframework.web.bind.annotation.*;
import com.workouttracker.rest.model.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    private Map<Long, User> usersMap = new HashMap<>();

    @GetMapping
    public Collection<User> getAllUsers() {
        return usersMap.values();
    }

    @PostMapping
    public void addUser(@RequestBody User user) {
        usersMap.put(user.getId(), user);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody User user) {
        usersMap.put(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        usersMap.remove(id);
    }
}