package com.researchlab.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "publications")
public class Publication {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer year;
    @Column(length = 2000, nullable = false)
    private String title;
    @Column(length = 2000)
    private String authors;
    private String journal;
    private String doiUrl;
    @Column(length = 3000)
    private String description;
    private String imageUrl;
    private Integer displayOrder = 0;

    public Long getId(){return id;}
    public Integer getYear(){return year;}
    public void setYear(Integer v){year=v;}
    public String getTitle(){return title;}
    public void setTitle(String v){title=v;}
    public String getAuthors(){return authors;}
    public void setAuthors(String v){authors=v;}
    public String getJournal(){return journal;}
    public void setJournal(String v){journal=v;}
    public String getDoiUrl(){return doiUrl;}
    public void setDoiUrl(String v){doiUrl=v;}
    public String getDescription(){return description;}
    public void setDescription(String v){description=v;}
    public String getImageUrl(){return imageUrl;}
    public void setImageUrl(String v){imageUrl=v;}
    public Integer getDisplayOrder(){return displayOrder;}
    public void setDisplayOrder(Integer v){displayOrder=v;}
}
