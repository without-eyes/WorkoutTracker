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
        return statsRepository.findByUserId(userID).orElse(null);
    }

    public Stats updateStats(Long userID, Stats stats) {
        stats.setId(userID);
        stats.setUserId(userID);
        return statsRepository.save(stats);
    }

    public Stats saveStats(Long userID, Stats stats) {
        stats.setUserId(userID);
        return statsRepository.save(stats);
    }

    public void deleteStats(Long userID) {
        statsRepository.deleteByUserId(userID);
    }
}