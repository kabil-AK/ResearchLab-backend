package com.researchlab.controller;

import com.researchlab.entity.GalleryItem;
import com.researchlab.repository.GalleryItemRepository;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class GalleryItemController {
    private final GalleryItemRepository repository;

    public GalleryItemController(GalleryItemRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/public/gallery")
    public List<GalleryItem> publicList() {
        return repository.findAll();
    }

    @GetMapping("/admin/gallery")
    public List<GalleryItem> adminList() {
        return repository.findAll();
    }

    @PostMapping("/admin/gallery")
    public GalleryItem create(@RequestBody GalleryItem item) {
        return repository.save(item);
    }

    @PutMapping("/admin/gallery/{id}")
    public GalleryItem update(@PathVariable Long id, @RequestBody GalleryItem item) {
        item.getClass();
        item = copyId(item, id);
        return repository.save(item);
    }

    @DeleteMapping("/admin/gallery/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

    private GalleryItem copyId(GalleryItem item, Long id) {
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
