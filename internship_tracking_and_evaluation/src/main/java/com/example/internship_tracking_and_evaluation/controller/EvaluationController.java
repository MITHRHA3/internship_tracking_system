package com.example.internship_tracking_and_evaluation.controller;

import com.example.internship_tracking_and_evaluation.entity.Evaluation;
import com.example.internship_tracking_and_evaluation.service.EvaluationService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/evaluations")

public class EvaluationController {

    private final EvaluationService evaluationService;

    public EvaluationController(EvaluationService evaluationService) {
        this.evaluationService = evaluationService;
    }

    @GetMapping
    public List<Evaluation> getAll() {
        return evaluationService.getAllEvaluations();
    }

    @GetMapping("/{id}")
    public Evaluation getById(@PathVariable Long id) {
        return evaluationService.getEvaluationById(id);
    }

    @PostMapping
    public Evaluation create(@RequestBody Evaluation evaluation) {
        return evaluationService.saveEvaluation(evaluation);
    }

    @PutMapping("/{id}")
    public Evaluation update(@PathVariable Long id, @RequestBody Evaluation evaluation) {
        return evaluationService.updateEvaluation(id, evaluation);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        evaluationService.deleteEvaluation(id);
    }
}
