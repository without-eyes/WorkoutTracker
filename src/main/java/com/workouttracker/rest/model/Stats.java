package com.workouttracker.rest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Stats")
@NoArgsConstructor
@AllArgsConstructor
public class Stats {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private int id;

    @Column(name = "UserId")
    private int userId;

    @Column(name = "TotalWorkouts")
    private int totalWorkouts;

    @Column(name = "TotalDuration")
    private int totalDuration;
}
