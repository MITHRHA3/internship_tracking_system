package com.example.internship_tracking_and_evaluation.service;

import com.example.internship_tracking_and_evaluation.entity.Mentor;
import com.example.internship_tracking_and_evaluation.repository.MentorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MentorService {

    private final MentorRepository mentorRepository;

    public MentorService(MentorRepository mentorRepository) {
        this.mentorRepository = mentorRepository;
    }

    public List<Mentor> getAllMentors() {
        return mentorRepository.findAll();
    }

    public Mentor getMentorById(Long id) {
        return mentorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mentor not found with ID: " + id));
    }

    public Mentor saveMentor(Mentor mentor) {
        return mentorRepository.save(mentor);
    }

    public Mentor updateMentor(Long id, Mentor updated) {
        Mentor existing = getMentorById(id);
        existing.setName(updated.getName());
        existing.setEmail(updated.getEmail());
        return mentorRepository.save(existing);
    }

    public void deleteMentor(Long id) {
        mentorRepository.deleteById(id);
    }
}
