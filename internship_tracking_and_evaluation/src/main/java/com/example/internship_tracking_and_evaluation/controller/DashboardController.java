package com.example.internship_tracking_and_evaluation.controller;

import com.example.internship_tracking_and_evaluation.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    private final StudentService studentService;
    private final MentorService mentorService;
    private final InternshipService internshipService;
    private final EvaluationService evaluationService;
   

    public DashboardController(StudentService studentService, MentorService mentorService,
                               InternshipService internshipService, EvaluationService evaluationService) {
        this.studentService = studentService;
        this.mentorService = mentorService;
        this.internshipService = internshipService;
        this.evaluationService = evaluationService;
       
    }

    @GetMapping("/")
    public String dashboard(Model model) {
        model.addAttribute("studentCount", studentService.getAllStudents().size());
        model.addAttribute("mentorCount", mentorService.getAllMentors().size());
        model.addAttribute("internshipCount", internshipService.getAllInternships().size());
        model.addAttribute("evaluationCount", evaluationService.getAllEvaluations().size());
        
        return "dashboard/dashboard"; 
    }
    
    @GetMapping("/dashboard")
    public String dashboardPath(Model model) {
        model.addAttribute("studentCount", studentService.getAllStudents().size());
        model.addAttribute("mentorCount", mentorService.getAllMentors().size());
        model.addAttribute("internshipCount", internshipService.getAllInternships().size());
        model.addAttribute("evaluationCount", evaluationService.getAllEvaluations().size());
        return "dashboard/dashboard";
    }
}
