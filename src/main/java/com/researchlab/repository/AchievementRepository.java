package com.researchlab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.researchlab.entity.Achievement;

import java.util.Optional;
import java.util.List;

public interface AchievementRepository extends JpaRepository<Achievement, Long> {
    List<Achievement> findAllByOrderByDisplayOrderAsc();
}
