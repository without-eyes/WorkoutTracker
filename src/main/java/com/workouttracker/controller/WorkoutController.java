package com.workouttracker.controller;

import org.springframework.web.bind.annotation.*;
import com.workouttracker.model.Workout;
import com.workouttracker.service.WorkoutService;

import java.util.List;

@RestController
@RequestMapping("/users/{userId}/workouts")
public class WorkoutController {
    private final WorkoutService workoutService;

    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @GetMapping
    public List<Workout> getAllWorkouts() {
        return workoutService.getAllWorkouts();
    }

    @GetMapping("/{id}")
    public Workout getWorkoutByUserIdAndId(@PathVariable Long userId, @PathVariable Long id) {
        return workoutService.getWorkoutByUserIdAndId(userId, id);
    }

    @PostMapping
    public Workout addWorkout(@PathVariable Long userId, @RequestBody Workout workout) {
        workout.setUserId(userId);
        return workoutService.saveWorkout(workout);
    }

    @PatchMapping("/{id}")
    public Workout updateWorkout(@PathVariable Long userId, @PathVariable Long id, @RequestBody Workout workout) {
        return workoutService.updateWorkout(userId, id, workout);
    }

    @DeleteMapping("/{id}")
    public void deleteWorkout(@PathVariable Long id) {
        workoutService.deleteWorkout(id);
    }
}