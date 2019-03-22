package com.briup.party.bean.table;

public class Useretd {
    private Short id;

    private String nativeplace;

    private Boolean isBdmanager;

    private Byte age;

    private String maritalstatue;

    private String joinjobdate;

    private String unitname;

    private String majorname;

    private String frontlinesituation;

    private String newsocialtype;

    private Boolean isMigrantworker;

    private String trainingstatue;

    private String imageurl;

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getNativeplace() {
        return nativeplace;
    }

    public void setNativeplace(String nativeplace) {
        this.nativeplace = nativeplace == null ? null : nativeplace.trim();
    }

    public Boolean getIsBdmanager() {
        return isBdmanager;
    }

    public void setIsBdmanager(Boolean isBdmanager) {
        this.isBdmanager = isBdmanager;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    public String getMaritalstatue() {
        return maritalstatue;
    }

    public void setMaritalstatue(String maritalstatue) {
        this.maritalstatue = maritalstatue == null ? null : maritalstatue.trim();
    }

    public String getJoinjobdate() {
        return joinjobdate;
    }

    public void setJoinjobdate(String joinjobdate) {
        this.joinjobdate = joinjobdate == null ? null : joinjobdate.trim();
    }

    public String getUnitname() {
        return unitname;
    }

    public void setUnitname(String unitname) {
        this.unitname = unitname == null ? null : unitname.trim();
    }

    public String getMajorname() {
        return majorname;
    }

    public void setMajorname(String majorname) {
        this.majorname = majorname == null ? null : majorname.trim();
    }

    public String getFrontlinesituation() {
        return frontlinesituation;
    }

    public void setFrontlinesituation(String frontlinesituation) {
        this.frontlinesituation = frontlinesituation == null ? null : frontlinesituation.trim();
    }

    public String getNewsocialtype() {
        return newsocialtype;
    }

    public void setNewsocialtype(String newsocialtype) {
        this.newsocialtype = newsocialtype == null ? null : newsocialtype.trim();
    }

    public Boolean getIsMigrantworker() {
        return isMigrantworker;
    }

    public void setIsMigrantworker(Boolean isMigrantworker) {
        this.isMigrantworker = isMigrantworker;
    }

    public String getTrainingstatue() {
        return trainingstatue;
    }

    public void setTrainingstatue(String trainingstatue) {
        this.trainingstatue = trainingstatue == null ? null : trainingstatue.trim();
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl == null ? null : imageurl.trim();
    }
}