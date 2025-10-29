package com.example.internship_tracking_and_evaluation.repository;

import com.example.internship_tracking_and_evaluation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
