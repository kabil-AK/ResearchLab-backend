package com.researchlab.repository;

import com.researchlab.entity.ResearchArea;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResearchAreaRepository extends JpaRepository<ResearchArea, Long> {

    List<ResearchArea> findAllByOrderByDisplayOrderAsc();
}