package com.example.internship_tracking_and_evaluation.repository;

import com.example.internship_tracking_and_evaluation.entity.Progress;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProgressRepository extends JpaRepository<Progress, Long> {
    List<Progress> findByInternshipId(Long internshipId);
}
