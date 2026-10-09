package com.researchlab.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "gallery_items")
public class GalleryItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String imageUrl;
    @Column(length = 1000)
    private String description;
    private Integer displayOrder = 0;

    public Long getId(){return id;}
    public String getTitle(){return title;}
    public void setTitle(String v){title=v;}
    public String getImageUrl(){return imageUrl;}
    public void setImageUrl(String v){imageUrl=v;}
    public String getDescription(){return description;}
    public void setDescription(String v){description=v;}
    public Integer getDisplayOrder(){return displayOrder;}
    public void setDisplayOrder(Integer v){displayOrder=v;}
}
