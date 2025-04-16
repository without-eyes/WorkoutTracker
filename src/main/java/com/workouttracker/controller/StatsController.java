package com.workouttracker.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.workouttracker.model.Stats;
import com.workouttracker.service.StatsService;

@RestController
@RequestMapping("/users/{userId}/stats")
public class StatsController {
    private StatsService statsService;

    public StatsController(StatsService statsService) {
        this.statsService = statsService;
    }

    @GetMapping
    public ResponseEntity<Stats> getStatsById(@PathVariable Long userId) {
        Stats foundStats = statsService.getStatsById(userId);
        if (foundStats != null) {
            return ResponseEntity.status(200).body(foundStats);
        } else {
            return ResponseEntity.status(204).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Stats> addStats(@PathVariable Long userId, @RequestBody Stats stats) {
        return ResponseEntity.status(201).body(statsService.saveStats(userId, stats));
    }

    @PatchMapping
    public ResponseEntity<Stats> updateStats(@PathVariable Long userId, @RequestBody Stats stats) {
        Stats updatedStats = statsService.updateStats(userId, stats);
        if (updatedStats != null) {
            return ResponseEntity.status(200).body(updatedStats);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }

    @DeleteMapping
    public ResponseEntity<Stats> deleteStats(@PathVariable Long userId) {
        statsService.deleteStats(userId);
        return ResponseEntity.status(204).body(null);
    }
}
