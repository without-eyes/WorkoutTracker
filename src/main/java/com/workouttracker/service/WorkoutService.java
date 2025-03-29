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

    public Workout getWorkoutByUserIdAndId(Long userId, Long id) {
        return workoutRepository.findByUserIdAndId(userId, id).orElse(null);
    }

    public Workout updateWorkout(Long userId, Long id, Workout updates) {
        return workoutRepository.findByUserIdAndId(userId, id).map(existingWorkout -> {
            if (updates.getType() != null) {
                existingWorkout.setType(updates.getType());
            }
            if (updates.getDuration() > 0) {
                existingWorkout.setDuration(updates.getDuration());
            }
            if (updates.getDate() != null) {
                existingWorkout.setDate(updates.getDate());
            }
            return workoutRepository.save(existingWorkout);
        }).orElse(null);
    }

    public Workout saveWorkout(Workout workout) {
        return workoutRepository.save(workout);
    }

    public void deleteWorkout(Long id) {
        workoutRepository.deleteById(id);
    }
}