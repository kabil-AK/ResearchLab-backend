package com.researchlab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.researchlab.entity.SiteInfo;

public interface SiteInfoRepository extends JpaRepository<SiteInfo, Long> {
}
