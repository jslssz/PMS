package com.briup.party.bean.table;

public class Branch {
    private Short id;

    private String name;

    private Short academyId;

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

    public Short getAcademyId() {
        return academyId;
    }

    public void setAcademyId(Short academyId) {
        this.academyId = academyId;
    }
}