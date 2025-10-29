package com.example.internship_tracking_and_evaluation.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Progress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;          // Date of the progress update
    private String taskDescription;  // What the student worked on
    private String status;           // e.g., "Pending", "Completed", "In Review"
    private String remarks;          // Mentor comments or feedback

    @ManyToOne
    @JoinColumn(name = "internship_id")
    private Internship internship;   // Link to specific internship
}
