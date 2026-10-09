package com.researchlab.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(length = 5000)
    private String description;

    private String status;

    private Integer startYear;

    private Integer endYear;

    private String fundingAgency;

    private String imageUrl;

    private String projectUrl;

    private Integer displayOrder = 0;

    public Project() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        title = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String value) {
        description = value;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String value) {
        status = value;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public void setStartYear(Integer value) {
        startYear = value;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public void setEndYear(Integer value) {
        endYear = value;
    }

    public String getFundingAgency() {
        return fundingAgency;
    }

    public void setFundingAgency(String value) {
        fundingAgency = value;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String value) {
        imageUrl = value;
    }

    public String getProjectUrl() {
        return projectUrl;
    }

    public void setProjectUrl(String value) {
        projectUrl = value;
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer value) {
        displayOrder = value;
    }
}