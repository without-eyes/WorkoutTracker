package com.workouttracker.rest.controller;

import org.springframework.web.bind.annotation.*;
import com.workouttracker.rest.model.Workout;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/workouts")
public class WorkoutController {
    private Map<Long, Workout> workoutsMap = new HashMap<>();

    @GetMapping
    public Collection<Workout> getAllWorkouts() {
        return workoutsMap.values();
    }

    @PostMapping
    public void addWorkout(@RequestBody Workout workout) {
        workoutsMap.put(workout.getId(), workout);
    }

    @PutMapping("/{id}")
    public void updateWorkout(@PathVariable Long id, @RequestBody Workout workout) {
        workoutsMap.put(id, workout);
    }

    @DeleteMapping("/{id}")
    public void deleteWorkout(@PathVariable Long id) {
        workoutsMap.remove(id);
    }
}