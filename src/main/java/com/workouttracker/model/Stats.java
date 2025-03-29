package com.workouttracker.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "Stats")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Stats {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Long id;

    @Column(name = "TotalWorkouts")
    private int totalWorkouts;

    @Column(name = "TotalDuration")
    private int totalDuration;
}
