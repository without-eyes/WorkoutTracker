package com.workouttracker.controller;

import org.springframework.web.bind.annotation.*;
import com.workouttracker.model.Stats;
import com.workouttracker.service.StatsService;

@RestController
@RequestMapping("/users/{userId}/stats")
public class StatsController {
    private final StatsService statsService;

    public StatsController(StatsService statsService) {
        this.statsService = statsService;
    }

    @GetMapping
    public Stats getStatsById(@PathVariable Long userId) {
        return statsService.getStatsById(userId);
    }

    @PostMapping
    public Stats addStats(@PathVariable Long userId, @RequestBody Stats stats) {
        return statsService.saveStats(userId, stats);
    }

    @PatchMapping
    public Stats updateStats(@PathVariable Long userId, @RequestBody Stats stats) {
        return statsService.updateStats(userId, stats);
    }

    @DeleteMapping
    public void deleteStats(@PathVariable Long userId) {
        statsService.deleteStats(userId);
    }
}
