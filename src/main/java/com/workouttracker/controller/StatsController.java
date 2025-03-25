package com.workouttracker.controller;

import org.springframework.web.bind.annotation.*;
import com.workouttracker.model.Stats;
import com.workouttracker.service.StatsService;

@RestController
@RequestMapping("/users/{userID}/stats")
public class StatsController {
    private final StatsService statsService;

    public StatsController(StatsService statsService) {
        this.statsService = statsService;
    }

    @GetMapping
    public Stats getStatsById(@PathVariable Long userID) {
        return statsService.getStatsById(userID);
    }

    @PostMapping
    public Stats addStats(@PathVariable Long userID, @RequestBody Stats stats) {
        return statsService.saveStats(userID, stats);
    }

    @PatchMapping
    public Stats updateStats(@PathVariable Long userID, @RequestBody Stats stats) {
        return statsService.updateStats(userID, stats);
    }

    @DeleteMapping
    public void deleteStats(@PathVariable Long userID) {
        statsService.deleteStats(userID);
    }
}
