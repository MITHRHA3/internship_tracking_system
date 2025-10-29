package com.example.internship_tracking_and_evaluation.repository;

import com.example.internship_tracking_and_evaluation.entity.Internship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface InternshipRepository extends JpaRepository<Internship, Long> {
    List<Internship> findByStudentId(Long studentId);
    List<Internship> findByMentorId(Long mentorId);
}
