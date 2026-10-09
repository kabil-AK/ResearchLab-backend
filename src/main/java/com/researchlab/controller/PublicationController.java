package com.researchlab.controller;

import com.researchlab.entity.Publication;
import com.researchlab.repository.PublicationRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PublicationController {

    private final PublicationRepository repository;

    public PublicationController(PublicationRepository repository) {
        this.repository = repository;
    }

    // =========================
    // PUBLIC - VIEW PUBLICATIONS
    // =========================

    @GetMapping("/public/publications")
    public List<Publication> publicList() {
        return repository.findAllByOrderByYearDescDisplayOrderAsc();
    }

    // =========================
    // ADMIN - VIEW PUBLICATIONS
    // =========================

    @GetMapping("/admin/publications")
    public List<Publication> adminList() {
        return repository.findAllByOrderByYearDescDisplayOrderAsc();
    }

    // =========================
    // ADMIN - ADD PUBLICATION
    // =========================

    @PostMapping("/admin/publications")
    public Publication create(@RequestBody Publication item) {
        return repository.save(item);
    }

    // =========================
    // ADMIN - UPDATE PUBLICATION
    // =========================

    @PutMapping("/admin/publications/{id}")
    public ResponseEntity<?> update(
            @PathVariable Long id,
            @RequestBody Publication item) {

        return repository.findById(id)
                .map(existing -> {

                    existing.setYear(item.getYear());
                    existing.setTitle(item.getTitle());
                    existing.setAuthors(item.getAuthors());
                    existing.setJournal(item.getJournal());
                    existing.setDoiUrl(item.getDoiUrl());
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
    // ADMIN - DELETE PUBLICATION
    // =========================

    @DeleteMapping("/admin/publications/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);

        return ResponseEntity.ok("Publication deleted successfully");
    }
}