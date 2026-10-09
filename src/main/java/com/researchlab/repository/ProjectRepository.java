package com.researchlab.repository;

import com.researchlab.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    List<Project> findAllByOrderByStartYearDescDisplayOrderAsc();
}