package com.researchlab.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "funding")
public class Funding {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String projectName;
    private String fundingAgency;
    private String amount;
    private Integer year;
    @Column(length = 3000)
    private String description;
    private Integer displayOrder = 0;

    public Long getId(){return id;}
    public String getProjectName(){return projectName;}
    public void setProjectName(String v){projectName=v;}
    public String getFundingAgency(){return fundingAgency;}
    public void setFundingAgency(String v){fundingAgency=v;}
    public String getAmount(){return amount;}
    public void setAmount(String v){amount=v;}
    public Integer getYear(){return year;}
    public void setYear(Integer v){year=v;}
    public String getDescription(){return description;}
    public void setDescription(String v){description=v;}
    public Integer getDisplayOrder(){return displayOrder;}
    public void setDisplayOrder(Integer v){displayOrder=v;}
}
