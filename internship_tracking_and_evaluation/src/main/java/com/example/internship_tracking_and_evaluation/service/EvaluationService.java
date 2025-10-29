package com.example.internship_tracking_and_evaluation.service;

import com.example.internship_tracking_and_evaluation.entity.Evaluation;
import com.example.internship_tracking_and_evaluation.repository.EvaluationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluationService {

    private final EvaluationRepository evaluationRepository;

    public EvaluationService(EvaluationRepository evaluationRepository) {
        this.evaluationRepository = evaluationRepository;
    }

    public List<Evaluation> getAllEvaluations() {
        return evaluationRepository.findAll();
    }

    public Evaluation getEvaluationById(Long id) {
        return evaluationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evaluation not found with ID: " + id));
    }

    public Evaluation saveEvaluation(Evaluation evaluation) {
        return evaluationRepository.save(evaluation);
    }

    public Evaluation updateEvaluation(Long id, Evaluation updatedEvaluation) {
        Evaluation existing = getEvaluationById(id);
        existing.setRemarks(updatedEvaluation.getRemarks());
        existing.setScore(updatedEvaluation.getScore());
        existing.setStudent(updatedEvaluation.getStudent());
        existing.setMentor(updatedEvaluation.getMentor());
        return evaluationRepository.save(existing);
    }

    public void deleteEvaluation(Long id) {
        evaluationRepository.deleteById(id);
    }
}
