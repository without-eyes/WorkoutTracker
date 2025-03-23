package com.workouttracker.controller;

import org.springframework.web.bind.annotation.*;
import com.workouttracker.model.Workout;
import com.workouttracker.service.WorkoutService;

import java.util.List;

@RestController
@RequestMapping("/workouts")
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
    public Workout getWorkoutById(@PathVariable Long id) {
        return workoutService.getWorkoutById(id);
    }

    @PostMapping
    public Workout addWorkout(@RequestBody Workout workout) {
        return workoutService.saveWorkout(workout);
    }

    @PutMapping("/{id}")
    public Workout updateWorkout(@PathVariable Long id, @RequestBody Workout workout) {
        return workoutService.updateWorkout(id, workout);
    }

    @DeleteMapping("/{id}")
    public void deleteWorkout(@PathVariable Long id) {
        workoutService.deleteWorkout(id);
    }
}