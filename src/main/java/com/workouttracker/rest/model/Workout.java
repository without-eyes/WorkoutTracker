package com.workouttracker.rest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "Workouts")
@NoArgsConstructor
@AllArgsConstructor
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Long id;

    @Column(name = "UserId")
    private Long userId;

    @Column(name = "Type")
    private String type;

    @Column(name = "DurationInMinutes")
    private int duration;

    @Column(name = "Date")
    private LocalDateTime date;

}
