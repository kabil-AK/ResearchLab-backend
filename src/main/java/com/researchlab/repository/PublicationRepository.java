package com.researchlab.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.researchlab.entity.Publication;


import java.util.List;

public interface PublicationRepository extends JpaRepository<Publication, Long> {
    List<Publication> findAllByOrderByYearDescDisplayOrderAsc();
}
