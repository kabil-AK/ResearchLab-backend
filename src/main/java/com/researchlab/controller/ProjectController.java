package com.researchlab.controller;

import com.researchlab.entity.Project;
import com.researchlab.repository.ProjectRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjectController {

    private final ProjectRepository repository;

    public ProjectController(ProjectRepository repository) {
        this.repository = repository;
    }

    // =========================
    // PUBLIC - VIEW PROJECTS
    // =========================

    @GetMapping("/public/projects")
    public List<Project> publicList() {
        return repository.findAllByOrderByStartYearDescDisplayOrderAsc();
    }

    // =========================
    // ADMIN - VIEW PROJECTS
    // =========================

    @GetMapping("/admin/projects")
    public List<Project> adminList() {
        return repository.findAllByOrderByStartYearDescDisplayOrderAsc();
    }

    // =========================
    // ADMIN - ADD PROJECT
    // =========================

    @PostMapping("/admin/projects")
    public Project create(@RequestBody Project item) {
        return repository.save(item);
    }

    // =========================
    // ADMIN - UPDATE PROJECT
    // =========================

    @PutMapping("/admin/projects/{id}")
    public ResponseEntity<?> update(
            @PathVariable Long id,
            @RequestBody Project item) {

        return repository.findById(id)
                .map(existing -> {

                    existing.setTitle(item.getTitle());
                    existing.setDescription(item.getDescription());
                    existing.setStatus(item.getStatus());
                    existing.setStartYear(item.getStartYear());
                    existing.setEndYear(item.getEndYear());
                    existing.setFundingAgency(item.getFundingAgency());
                    existing.setImageUrl(item.getImageUrl());
                    existing.setProjectUrl(item.getProjectUrl());
                    existing.setDisplayOrder(item.getDisplayOrder());

                    return ResponseEntity.ok(repository.save(existing));
                })
                .orElseGet(() ->
                        ResponseEntity.notFound().build()
                );
    }

    // =========================
    // ADMIN - DELETE PROJECT
    // =========================

    @DeleteMapping("/admin/projects/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);

        return ResponseEntity.ok("Project deleted successfully");
    }
}