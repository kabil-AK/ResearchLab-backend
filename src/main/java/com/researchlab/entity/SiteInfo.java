package com.researchlab.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "site_info")
public class SiteInfo {
    @Id
    private Long id = 1L;
    private String labName;
    @Column(length = 3000)
    private String tagline;
    private String piName;
    private String piDesignation;
    private String piAffiliation;
    private String researchArea;
    @Column(length = 5000)
    private String aboutText;
    private String heroImageUrl;
    private String piImageUrl;
    private String address;
    private String email;
    private String phone;
    private String mapUrl;

    public Long getId(){return id;}
    public String getLabName(){return labName;}
    public void setLabName(String v){labName=v;}
    public String getTagline(){return tagline;}
    public void setTagline(String v){tagline=v;}
    public String getPiName(){return piName;}
    public void setPiName(String v){piName=v;}
    public String getPiDesignation(){return piDesignation;}
    public void setPiDesignation(String v){piDesignation=v;}
    public String getPiAffiliation(){return piAffiliation;}
    public void setPiAffiliation(String v){piAffiliation=v;}
    public String getResearchArea(){return researchArea;}
    public void setResearchArea(String v){researchArea=v;}
    public String getAboutText(){return aboutText;}
    public void setAboutText(String v){aboutText=v;}
    public String getHeroImageUrl(){return heroImageUrl;}
    public void setHeroImageUrl(String v){heroImageUrl=v;}
    public String getPiImageUrl(){return piImageUrl;}
    public void setPiImageUrl(String v){piImageUrl=v;}
    public String getAddress(){return address;}
    public void setAddress(String v){address=v;}
    public String getEmail(){return email;}
    public void setEmail(String v){email=v;}
    public String getPhone(){return phone;}
    public void setPhone(String v){phone=v;}
    public String getMapUrl(){return mapUrl;}
    public void setMapUrl(String v){mapUrl=v;}
}
