package com.researchlab.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.researchlab.entity.GalleryItem;


import java.util.List;

public interface GalleryItemRepository extends JpaRepository<GalleryItem, Long> {
    List<GalleryItem> findAllByOrderByDisplayOrderAsc();
}
