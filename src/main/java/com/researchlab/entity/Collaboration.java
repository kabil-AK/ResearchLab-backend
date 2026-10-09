package com.researchlab.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "collaborations")
public class Collaboration {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String organizationName;
    @Column(length = 3000)
    private String description;
    private String logoUrl;
    private String websiteUrl;
    private Integer displayOrder = 0;

    public Long getId(){return id;}
    public String getOrganizationName(){return organizationName;}
    public void setOrganizationName(String v){organizationName=v;}
    public String getDescription(){return description;}
    public void setDescription(String v){description=v;}
    public String getLogoUrl(){return logoUrl;}
    public void setLogoUrl(String v){logoUrl=v;}
    public String getWebsiteUrl(){return websiteUrl;}
    public void setWebsiteUrl(String v){websiteUrl=v;}
    public Integer getDisplayOrder(){return displayOrder;}
    public void setDisplayOrder(Integer v){displayOrder=v;}
}
