package com.example.internship_tracking_and_evaluation.service;

import com.example.internship_tracking_and_evaluation.entity.Progress;
import com.example.internship_tracking_and_evaluation.repository.ProgressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgressService {

    private final ProgressRepository progressRepository;

    public ProgressService(ProgressRepository progressRepository) {
        this.progressRepository = progressRepository;
    }

    public List<Progress> getAllProgress() {
        return progressRepository.findAll();
    }

    public Progress getProgressById(Long id) {
        return progressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Progress not found with ID: " + id));
    }

    public Progress saveProgress(Progress progress) {
        return progressRepository.save(progress);
    }

    public Progress updateProgress(Long id, Progress updated) {
        Progress existing = getProgressById(id);
        existing.setDate(updated.getDate());
        existing.setTaskDescription(updated.getTaskDescription());
        existing.setStatus(updated.getStatus());
        existing.setRemarks(updated.getRemarks());
        existing.setInternship(updated.getInternship());
        return progressRepository.save(existing);
    }

    public void deleteProgress(Long id) {
        progressRepository.deleteById(id);
    }

    public List<Progress> getByInternship(Long internshipId) {
        return progressRepository.findByInternshipId(internshipId);
    }
}
