package com.workouttracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.workouttracker.rest.model.Stats;
import org.springframework.stereotype.Repository;

@Repository
public interface StatsRepository extends JpaRepository<Stats, Long> {
}
