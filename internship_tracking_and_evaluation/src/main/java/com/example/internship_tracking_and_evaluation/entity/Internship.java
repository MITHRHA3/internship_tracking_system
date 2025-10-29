package com.example.internship_tracking_and_evaluation.entity;


import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Internship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;
    private String title;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status; // e.g., "Ongoing", "Completed", "Pending"

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "mentor_id")
    private Mentor mentor;
}
