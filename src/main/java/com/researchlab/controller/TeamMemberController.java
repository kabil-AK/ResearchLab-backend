package com.researchlab.controller;

import com.researchlab.entity.TeamMember;
import com.researchlab.repository.TeamMemberRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TeamMemberController {

    private final TeamMemberRepository repository;

    public TeamMemberController(TeamMemberRepository repository) {
        this.repository = repository;
    }

    // =========================
    // PUBLIC - VIEW TEAM
    // =========================

    @GetMapping("/public/team-members")
    public List<TeamMember> publicList() {
        return repository.findAllByOrderByDisplayOrderAsc();
    }

    // =========================
    // ADMIN - VIEW TEAM
    // =========================

    @GetMapping("/admin/team-members")
    public List<TeamMember> adminList() {
        return repository.findAllByOrderByDisplayOrderAsc();
    }

    // =========================
    // ADMIN - ADD MEMBER
    // =========================

    @PostMapping("/admin/team-members")
    public TeamMember create(@RequestBody TeamMember item) {
        return repository.save(item);
    }

    // =========================
    // ADMIN - UPDATE MEMBER
    // =========================

    @PutMapping("/admin/team-members/{id}")
    public ResponseEntity<?> update(
            @PathVariable Long id,
            @RequestBody TeamMember item) {

        return repository.findById(id)
                .map(existing -> {

                    existing.setName(item.getName());
                    existing.setDesignation(item.getDesignation());
                    existing.setExperience(item.getExperience());
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
    // ADMIN - DELETE MEMBER
    // =========================

    @DeleteMapping("/admin/team-members/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);

        return ResponseEntity.ok("Team member deleted successfully");
    }
}