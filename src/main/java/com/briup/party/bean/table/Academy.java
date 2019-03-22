package com.briup.party.bean.table;

public class Academy {
    private Short id;

    private String name;

    private Short collegeId;

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Short getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Short collegeId) {
        this.collegeId = collegeId;
    }
}