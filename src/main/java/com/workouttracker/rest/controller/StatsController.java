package com.workouttracker.rest.controller;

import org.springframework.web.bind.annotation.*;
import com.workouttracker.rest.model.Stats;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/stats")
public class StatsController {
    private Map<Long, Stats> statsMap = new HashMap<>();

    @GetMapping("/{userId}")
    public Stats getStats(@PathVariable Long userId) {
        return statsMap.get(userId);
    }

    @PostMapping
    public void addStats(@RequestBody Stats stats) {
        statsMap.put(stats.getUserId(), stats);
    }

    @PutMapping("/{userId}")
    public void updateStats(@PathVariable Long userId, @RequestBody Stats stats) {
        statsMap.put(userId, stats);
    }
}