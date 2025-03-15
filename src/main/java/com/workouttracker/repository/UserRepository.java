package com.workouttracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.workouttracker.rest.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
