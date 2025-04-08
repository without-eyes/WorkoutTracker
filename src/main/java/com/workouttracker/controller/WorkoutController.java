package com.workouttracker.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.workouttracker.model.Workout;
import com.workouttracker.service.WorkoutService;

import java.util.List;

@RestController
@RequestMapping("/users/{userId}/workouts")
public class WorkoutController {
    private WorkoutService workoutService;

    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @GetMapping
    public ResponseEntity<List<Workout>> getAllWorkouts() {
        List<Workout> workoutList = workoutService.getAllWorkouts();
        if (workoutList.isEmpty()) {
            return ResponseEntity.status(204).body(null);
        } else {
            return ResponseEntity.status(200).body(workoutList);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Workout> getWorkoutByUserIdAndId(@PathVariable Long userId, @PathVariable Long id) {
        Workout foundWorkout = workoutService.getWorkoutByUserIdAndId(userId, id);
        if (foundWorkout != null) {
            return ResponseEntity.status(200).body(foundWorkout);
        } else {
            return ResponseEntity.status(204).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Workout> addWorkout(@PathVariable Long userId, @RequestBody Workout workout) {
        workout.setUserId(userId);
        return ResponseEntity.status(201).body(workoutService.saveWorkout(workout));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Workout> updateWorkout(@PathVariable Long userId, @PathVariable Long id, @RequestBody Workout workout) {
        Workout updatedWorkout = workoutService.updateWorkout(userId, id, workout);
        if (updatedWorkout != null) {
            return ResponseEntity.status(200).body(updatedWorkout);
        } else {
            return ResponseEntity.status(202).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Workout> deleteWorkout(@PathVariable Long id) {
        workoutService.deleteWorkout(id);
        return ResponseEntity.status(204).body(null);
    }
}