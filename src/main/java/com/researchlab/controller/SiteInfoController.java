package com.researchlab.controller;

import com.researchlab.entity.SiteInfo;
import com.researchlab.repository.SiteInfoRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SiteInfoController {

    private final SiteInfoRepository repository;

    public SiteInfoController(SiteInfoRepository repository) {
        this.repository = repository;
    }

    // Visitor can view website information
    @GetMapping("/public/site-info")
    public SiteInfo publicInfo() {
        return repository.findById(1L)
                .orElseGet(SiteInfo::new);
    }

    // Admin can view website information
    @GetMapping("/admin/site-info")
    public SiteInfo adminInfo() {
        return repository.findById(1L)
                .orElseGet(SiteInfo::new);
    }

    // Admin can update website information
    @PutMapping("/admin/site-info")
    public SiteInfo update(@RequestBody SiteInfo item) {

        SiteInfo existing = repository.findById(1L)
                .orElseGet(SiteInfo::new);

        existing.setLabName(item.getLabName());
        existing.setTagline(item.getTagline());
        existing.setPiName(item.getPiName());
        existing.setPiDesignation(item.getPiDesignation());
        existing.setPiAffiliation(item.getPiAffiliation());
        existing.setResearchArea(item.getResearchArea());
        existing.setAboutText(item.getAboutText());
        existing.setHeroImageUrl(item.getHeroImageUrl());
        existing.setPiImageUrl(item.getPiImageUrl());
        existing.setAddress(item.getAddress());
        existing.setEmail(item.getEmail());
        existing.setPhone(item.getPhone());
        existing.setMapUrl(item.getMapUrl());

        return repository.save(existing);
    }
}