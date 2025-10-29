package com.example.internship_tracking_and_evaluation.repository;

import com.example.internship_tracking_and_evaluation.entity.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorRepository extends JpaRepository<Mentor, Long> {
}
