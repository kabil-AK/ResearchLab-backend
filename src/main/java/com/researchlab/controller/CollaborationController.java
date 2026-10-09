package com.researchlab.controller;

import com.researchlab.entity.Collaboration;
import com.researchlab.repository.CollaborationRepository;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CollaborationController {
    private final CollaborationRepository repository;

    public CollaborationController(CollaborationRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/public/collaborations")
    public List<Collaboration> publicList() {
        return repository.findAll();
    }

    @GetMapping("/admin/collaborations")
    public List<Collaboration> adminList() {
        return repository.findAll();
    }

    @PostMapping("/admin/collaborations")
    public Collaboration create(@RequestBody Collaboration item) {
        return repository.save(item);
    }

    @PutMapping("/admin/collaborations/{id}")
    public Collaboration update(@PathVariable Long id, @RequestBody Collaboration item) {
        item.getClass();
        item = copyId(item, id);
        return repository.save(item);
    }

    @DeleteMapping("/admin/collaborations/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

    private Collaboration copyId(Collaboration item, Long id) {
        try {
            var field = item.getClass().getDeclaredField("id");
            field.setAccessible(true);
            field.set(item, id);
        } catch (Exception ex) {
            throw new IllegalStateException("Unable to set id", ex);
        }
        return item;
    }
}
