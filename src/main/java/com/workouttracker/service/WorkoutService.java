package com.workouttracker.service;

import com.workouttracker.model.Workout;
import com.workouttracker.repository.WorkoutRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WorkoutService {
    private final WorkoutRepository workoutRepository;

    public WorkoutService(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    public List<Workout> getAllWorkouts() {
        return workoutRepository.findAll();
    }

    public Workout getWorkoutById(Long id) {
        return workoutRepository.findById(id).orElse(null);
    }

    public Workout updateWorkout(Long id, Workout workout) {
        workout.setId(id);
        return workoutRepository.save(workout);
    }

    public Workout saveWorkout(Workout workout) {
        return workoutRepository.save(workout);
    }

    public void deleteWorkout(Long id) {
        workoutRepository.deleteById(id);
    }
}