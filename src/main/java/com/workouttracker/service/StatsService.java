package com.workouttracker.service;

import com.workouttracker.rest.model.Stats;
import com.workouttracker.repository.StatsRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StatsService {
    private final StatsRepository statsRepository;

    public StatsService(StatsRepository statsRepository) {
        this.statsRepository = statsRepository;
    }

    public List<Stats> getAllStats() {
        return statsRepository.findAll();
    }

    public Stats getStatsById(Long id) {
        return statsRepository.findById(id).orElse(null);
    }

    public Stats saveStats(Stats stats) {
        return statsRepository.save(stats);
    }

    public void deleteStats(Long id) {
        statsRepository.deleteById(id);
    }
}