package com.researchlab.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.researchlab.entity.Funding;


import java.util.List;

public interface FundingRepository extends JpaRepository<Funding, Long> {
    List<Funding> findAllByOrderByYearDescDisplayOrderAsc();
}
