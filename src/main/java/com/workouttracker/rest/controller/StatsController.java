package com.workouttracker.rest.controller;

import org.springframework.web.bind.annotation.*;
import com.workouttracker.rest.model.Stats;
import com.workouttracker.service.StatsService;

import java.util.List;

@RestController
@RequestMapping("/stats")
public class StatsController {
    private final StatsService statsService;

    public StatsController(StatsService statsService) {
        this.statsService = statsService;
    }

    @GetMapping
    public List<Stats> getAllStats() {
        return statsService.getAllStats();
    }

    @GetMapping("/{id}")
    public Stats getStatsById(@PathVariable Long id) {
        return statsService.getStatsById(id);
    }

    @PostMapping
    public Stats addStats(@RequestBody Stats stats) {
        return statsService.saveStats(stats);
    }

    @PutMapping("/{id}")
    public Stats updateStats(@PathVariable Long id, @RequestBody Stats stats) {
        return statsService.updateStats(id, stats);
    }

    @DeleteMapping("/{id}")
    public void deleteStats(@PathVariable Long id) {
        statsService.deleteStats(id);
    }
}