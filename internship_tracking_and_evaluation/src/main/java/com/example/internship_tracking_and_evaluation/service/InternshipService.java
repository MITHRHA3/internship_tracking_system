package com.example.internship_tracking_and_evaluation.service;

import com.example.internship_tracking_and_evaluation.entity.Internship;
import com.example.internship_tracking_and_evaluation.repository.InternshipRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InternshipService {

    private final InternshipRepository internshipRepository;

    public InternshipService(InternshipRepository internshipRepository) {
        this.internshipRepository = internshipRepository;
    }

    public List<Internship> getAllInternships() {
        return internshipRepository.findAll();
    }

    public Internship getInternshipById(Long id) {
        return internshipRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Internship not found with ID: " + id));
    }

    public Internship saveInternship(Internship internship) {
        return internshipRepository.save(internship);
    }

    public Internship updateInternship(Long id, Internship updatedInternship) {
        Internship existing = getInternshipById(id);
        existing.setCompanyName(updatedInternship.getCompanyName());
        existing.setTitle(updatedInternship.getTitle());
        existing.setStartDate(updatedInternship.getStartDate());
        existing.setEndDate(updatedInternship.getEndDate());
        existing.setStatus(updatedInternship.getStatus());
        existing.setStudent(updatedInternship.getStudent());
        existing.setMentor(updatedInternship.getMentor());
        return internshipRepository.save(existing);
    }

    public void deleteInternship(Long id) {
        internshipRepository.deleteById(id);
    }

    public List<Internship> getInternshipsByStudent(Long studentId) {
        return internshipRepository.findByStudentId(studentId);
    }

    public List<Internship> getInternshipsByMentor(Long mentorId) {
        return internshipRepository.findByMentorId(mentorId);
    }
}
