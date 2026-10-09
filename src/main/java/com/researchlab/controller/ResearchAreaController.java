package com.researchlab.controller;

import com.researchlab.entity.ResearchArea;
import com.researchlab.repository.ResearchAreaRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ResearchAreaController {

    private final ResearchAreaRepository repository;

    public ResearchAreaController(ResearchAreaRepository repository) {
        this.repository = repository;
    }

    // =========================
    // PUBLIC - VIEW RESEARCH AREAS
    // =========================

    @GetMapping("/public/research-areas")
    public List<ResearchArea> publicList() {
        return repository.findAllByOrderByDisplayOrderAsc();
    }

    // =========================
    // ADMIN - VIEW RESEARCH AREAS
    // =========================

    @GetMapping("/admin/research-areas")
    public List<ResearchArea> adminList() {
        return repository.findAllByOrderByDisplayOrderAsc();
    }

    // =========================
    // ADMIN - ADD RESEARCH AREA
    // =========================

    @PostMapping("/admin/research-areas")
    public ResearchArea create(@RequestBody ResearchArea item) {
        return repository.save(item);
    }

    // =========================
    // ADMIN - UPDATE RESEARCH AREA
    // =========================

    @PutMapping("/admin/research-areas/{id}")
    public ResponseEntity<?> update(
            @PathVariable Long id,
            @RequestBody ResearchArea item) {

        return repository.findById(id)
                .map(existing -> {

                    existing.setTitle(item.getTitle());
                    existing.setShortDescription(item.getShortDescription());
                    existing.setDescription(item.getDescription());
                    existing.setImageUrl(item.getImageUrl());
                    existing.setDisplayOrder(item.getDisplayOrder());

                    return ResponseEntity.ok(repository.save(existing));
                })
                .orElseGet(() ->
                        ResponseEntity.notFound().build()
                );
    }

    // =========================
    // ADMIN - DELETE RESEARCH AREA
    // =========================

    @DeleteMapping("/admin/research-areas/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);

        return ResponseEntity.ok("Research area deleted successfully");
    }
}