package com.example.internship_tracking_and_evaluation.controller;

import com.example.internship_tracking_and_evaluation.entity.Internship;
import com.example.internship_tracking_and_evaluation.service.InternshipService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/internships")

public class InternshipController {

    private final InternshipService internshipService;

    public InternshipController(InternshipService internshipService) {
        this.internshipService = internshipService;
    }

    @GetMapping
    public List<Internship> getAllInternships() {
        return internshipService.getAllInternships();
    }

    @GetMapping("/{id}")
    public Internship getInternshipById(@PathVariable Long id) {
        return internshipService.getInternshipById(id);
    }

    @PostMapping
    public Internship createInternship(@RequestBody Internship internship) {
        return internshipService.saveInternship(internship);
    }

    @PutMapping("/{id}")
    public Internship updateInternship(@PathVariable Long id, @RequestBody Internship internship) {
        return internshipService.updateInternship(id, internship);
    }

    @DeleteMapping("/{id}")
    public String deleteInternship(@PathVariable Long id) {
        internshipService.deleteInternship(id);
        return "Internship with ID " + id + " deleted successfully!";
    }

    @GetMapping("/student/{studentId}")
    public List<Internship> getInternshipsByStudent(@PathVariable Long studentId) {
        return internshipService.getInternshipsByStudent(studentId);
    }

    @GetMapping("/mentor/{mentorId}")
    public List<Internship> getInternshipsByMentor(@PathVariable Long mentorId) {
        return internshipService.getInternshipsByMentor(mentorId);
    }
}
