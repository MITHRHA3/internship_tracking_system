package com.example.internship_tracking_and_evaluation.repository;

import com.example.internship_tracking_and_evaluation.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
