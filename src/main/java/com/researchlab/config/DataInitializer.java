package com.researchlab.config;

import com.researchlab.entity.AdminUser;
import com.researchlab.entity.SiteInfo;
import com.researchlab.repository.AdminUserRepository;
import com.researchlab.repository.SiteInfoRepository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initialize(
            AdminUserRepository adminRepo,
            SiteInfoRepository siteRepo,
            PasswordEncoder encoder,
            @Value("${app.admin-email}") String email,
            @Value("${app.admin-password}") String password) {

        return args -> {

            // Create default admin
            if (adminRepo.findByEmail(email).isEmpty()) {

                AdminUser admin = new AdminUser();

                admin.setEmail(email);
                admin.setPassword(encoder.encode(password));
                admin.setRole("ADMIN");

                adminRepo.save(admin);
            }

            // Create default website information
            if (siteRepo.count() == 0) {

                SiteInfo info = new SiteInfo();

                info.setLabName(
                        "Sustainable Energy & Environmental Research Lab"
                );

                info.setTagline(
                        "For a sustainable society, we design novel materials and processes."
                );

                info.setPiName(
                        "Principal Investigator Name"
                );

                info.setPiDesignation(
                        "Research Assistant Professor"
                );

                info.setPiAffiliation(
                        "Department / Institution"
                );

                info.setResearchArea(
                        "Chemistry / Environmental Chemistry"
                );

                info.setAboutText(
                        "Lab information will be added and maintained by the administrator."
                );

                siteRepo.save(info);
            }
        };
    }
}