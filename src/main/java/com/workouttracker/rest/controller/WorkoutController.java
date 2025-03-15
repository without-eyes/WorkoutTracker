package com.workouttracker.rest.controller;

import org.springframework.web.bind.annotation.*;
import com.workouttracker.rest.model.Workout;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/workouts")
public class WorkoutController {
    private Map<Long, Workout> workouts = new HashMap<>();

    @GetMapping
    public Collection<Workout> getAllWorkouts() {
        return workouts.values();
    }

    @PostMapping
    public void addWorkout(@RequestBody Workout workout) {
        workouts.put(workout.getId(), workout);
    }

    @PutMapping("/{id}")
    public void updateWorkout(@PathVariable Long id, @RequestBody Workout workout) {
        workouts.put(id, workout);
    }

    @DeleteMapping("/{id}")
    public void deleteWorkout(@PathVariable Long id) {
        workouts.remove(id);
    }
}