package com.researchlab.controller;

import com.researchlab.entity.Achievement;
import com.researchlab.repository.AchievementRepository;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AchievementController {
    private final AchievementRepository repository;

    public AchievementController(AchievementRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/public/achievements")
    public List<Achievement> publicList() {
        return repository.findAll();
    }

    @GetMapping("/admin/achievements")
    public List<Achievement> adminList() {
        return repository.findAll();
    }

    @PostMapping("/admin/achievements")
    public Achievement create(@RequestBody Achievement item) {
        return repository.save(item);
    }

    @PutMapping("/admin/achievements/{id}")
    public Achievement update(@PathVariable Long id, @RequestBody Achievement item) {
        item.getClass();
        item = copyId(item, id);
        return repository.save(item);
    }

    @DeleteMapping("/admin/achievements/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

    private Achievement copyId(Achievement item, Long id) {
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
