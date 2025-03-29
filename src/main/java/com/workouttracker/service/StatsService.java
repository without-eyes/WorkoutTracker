package com.workouttracker.service;

import com.workouttracker.model.Stats;
import com.workouttracker.repository.StatsRepository;
import org.springframework.stereotype.Service;

@Service
public class StatsService {
    private final StatsRepository statsRepository;

    public StatsService(StatsRepository statsRepository) {
        this.statsRepository = statsRepository;
    }

    public Stats getStatsById(Long userID) {
        return statsRepository.findById(userID).orElse(null);
    }

    public Stats updateStats(Long userId, Stats updates) {
        return statsRepository.findById(userId).map(existingStats -> {
            if (updates.getTotalWorkouts() > 0) {
                existingStats.setTotalWorkouts(updates.getTotalWorkouts());
            }
            if (updates.getTotalDuration() > 0) {
                existingStats.setTotalDuration(updates.getTotalDuration());
            }
            return statsRepository.save(existingStats);
        }).orElse(null);
    }

    public Stats saveStats(Long userID, Stats stats) {
        stats.setId(userID);
        return statsRepository.save(stats);
    }

    public void deleteStats(Long userID) {
        statsRepository.deleteById(userID);
    }
}