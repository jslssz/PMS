package com.briup.party.bean.tableVM;

public class DevModal {
    private Short id;
    private String name;
    private String branchName;
    private String time;
    private String category;
    private double dataCompleteness;

    public DevModal() {
    }
    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public DevModal(Short id, String name, String branchName, String time, String category, double dataCompleteness) {
        this.id = id;
        this.name = name;
        this.branchName = branchName;
        this.time = time;
        this.category = category;
        this.dataCompleteness = dataCompleteness;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getDataCompleteness() {
        return dataCompleteness;
    }

    public void setDataCompleteness(double dataCompleteness) {
        this.dataCompleteness = dataCompleteness;
    }
}
