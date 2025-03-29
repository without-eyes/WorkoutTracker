package com.workouttracker.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "Users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Username")
    private String username;

    @Column(name = "PasswordHash")
    private String password;
}
