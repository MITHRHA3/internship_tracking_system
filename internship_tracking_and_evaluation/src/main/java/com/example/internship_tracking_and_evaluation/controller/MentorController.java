package com.example.internship_tracking_and_evaluation.controller;

import com.example.internship_tracking_and_evaluation.entity.Mentor;
import com.example.internship_tracking_and_evaluation.service.MentorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mentors")
@CrossOrigin(origins = "*")
public class MentorController {

    private final MentorService mentorService;

    public MentorController(MentorService mentorService) {
        this.mentorService = mentorService;
    }

    @GetMapping
    public List<Mentor> getAllMentors() {
        return mentorService.getAllMentors();
    }

    @GetMapping("/{id}")
    public Mentor getMentorById(@PathVariable Long id) {
        return mentorService.getMentorById(id);
    }

    @PostMapping
    public Mentor createMentor(@RequestBody Mentor mentor) {
        return mentorService.saveMentor(mentor);
    }

    @PutMapping("/{id}")
    public Mentor updateMentor(@PathVariable Long id, @RequestBody Mentor updated) {
        return mentorService.updateMentor(id, updated);
    }

    @DeleteMapping("/{id}")
    public void deleteMentor(@PathVariable Long id) {
        mentorService.deleteMentor(id);
    }
}
