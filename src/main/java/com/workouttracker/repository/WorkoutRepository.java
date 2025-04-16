package com.workouttracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.workouttracker.model.Workout;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Long> {
    Optional<Workout> findByUserIdAndId(Long userId, Long id);

    List<Workout> findAllByUserId(Long userId);
}