package com.researchlab.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.researchlab.entity.AdminUser;

import java.util.Optional;
import java.util.List;

public interface AdminUserRepository extends JpaRepository<AdminUser, Long> {
    Optional<AdminUser> findByEmail(String email);
}
