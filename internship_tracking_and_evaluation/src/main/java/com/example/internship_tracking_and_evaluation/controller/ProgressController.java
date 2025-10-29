package com.example.internship_tracking_and_evaluation.controller;

import com.example.internship_tracking_and_evaluation.entity.Progress;
import com.example.internship_tracking_and_evaluation.service.ProgressService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/progress")
@CrossOrigin(origins = "*")
public class ProgressController {

    private final ProgressService progressService;

    public ProgressController(ProgressService progressService) {
        this.progressService = progressService;
    }

    @GetMapping
    public List<Progress> getAllProgress() {
        return progressService.getAllProgress();
    }

    @GetMapping("/{id}")
    public Progress getProgressById(@PathVariable Long id) {
        return progressService.getProgressById(id);
    }

    @PostMapping
    public Progress createProgress(@RequestBody Progress progress) {
        return progressService.saveProgress(progress);
    }

    @PutMapping("/{id}")
    public Progress updateProgress(@PathVariable Long id, @RequestBody Progress progress) {
        return progressService.updateProgress(id, progress);
    }

    @DeleteMapping("/{id}")
    public void deleteProgress(@PathVariable Long id) {
        progressService.deleteProgress(id);
    }
}
