package com.researchlab.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "achievements")
public class Achievement {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dateLabel;
    @Column(length = 2000)
    private String title;
    @Column(length = 4000)
    private String description;
    private String imageUrl;
    private String externalUrl;
    private Integer displayOrder = 0;

    public Long getId(){return id;}
    public String getDateLabel(){return dateLabel;}
    public void setDateLabel(String v){dateLabel=v;}
    public String getTitle(){return title;}
    public void setTitle(String v){title=v;}
    public String getDescription(){return description;}
    public void setDescription(String v){description=v;}
    public String getImageUrl(){return imageUrl;}
    public void setImageUrl(String v){imageUrl=v;}
    public String getExternalUrl(){return externalUrl;}
    public void setExternalUrl(String v){externalUrl=v;}
    public Integer getDisplayOrder(){return displayOrder;}
    public void setDisplayOrder(Integer v){displayOrder=v;}
}
