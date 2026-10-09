package com.researchlab.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.researchlab.entity.Collaboration;


import java.util.List;

public interface CollaborationRepository extends JpaRepository<Collaboration, Long> {
    List<Collaboration> findAllByOrderByDisplayOrderAsc();
}
