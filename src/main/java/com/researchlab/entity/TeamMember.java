package com.researchlab.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "team_members")
public class TeamMember {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String designation;
    private String experience;
    @Column(length = 3000)
    private String description;
    private String imageUrl;
    private Integer displayOrder = 0;

    public Long getId(){return id;}
    public String getName(){return name;}
    public void setName(String v){name=v;}
    public String getDesignation(){return designation;}
    public void setDesignation(String v){designation=v;}
    public String getExperience(){return experience;}
    public void setExperience(String v){experience=v;}
    public String getDescription(){return description;}
    public void setDescription(String v){description=v;}
    public String getImageUrl(){return imageUrl;}
    public void setImageUrl(String v){imageUrl=v;}
    public Integer getDisplayOrder(){return displayOrder;}
    public void setDisplayOrder(Integer v){displayOrder=v;}
}
