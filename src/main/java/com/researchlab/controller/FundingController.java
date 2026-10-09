package com.researchlab.controller;

import com.researchlab.entity.Funding;
import com.researchlab.repository.FundingRepository;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FundingController {
    private final FundingRepository repository;

    public FundingController(FundingRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/public/funding")
    public List<Funding> publicList() {
        return repository.findAll();
    }

    @GetMapping("/admin/funding")
    public List<Funding> adminList() {
        return repository.findAll();
    }

    @PostMapping("/admin/funding")
    public Funding create(@RequestBody Funding item) {
        return repository.save(item);
    }

    @PutMapping("/admin/funding/{id}")
    public Funding update(@PathVariable Long id, @RequestBody Funding item) {
        item.getClass();
        item = copyId(item, id);
        return repository.save(item);
    }

    @DeleteMapping("/admin/funding/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

    private Funding copyId(Funding item, Long id) {
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
