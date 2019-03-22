package com.briup.party.bean.count;

import java.util.List;

/**
 * 封装返回的用户统计数据的pojo类
 */
public class CollegeCount {
    private String name;
    private int storageNumber;
    private int prepareNumber;
    private int femaleNumber;
    private int minorityNumber;
    private int collegeNumber;
    private List<AcademyCount> academyCounts;
    public  CollegeCount(){}
    public CollegeCount(String name, int storageNumber, int prepareNumber, int femaleNumber, int minorityNumber, int collegeNumber, List<AcademyCount> academyCounts) {
        this.name = name;
        this.storageNumber = storageNumber;
        this.prepareNumber = prepareNumber;
        this.femaleNumber = femaleNumber;
        this.minorityNumber = minorityNumber;
        this.collegeNumber = collegeNumber;
        this.academyCounts = academyCounts;
    }

    public List<AcademyCount> getAcademyCounts() {
        return academyCounts;
    }

    public void setAcademyCounts(List<AcademyCount> academyCounts) {
        this.academyCounts = academyCounts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public int getStorageNumber() {
        return storageNumber;
    }

    public void setStorageNumber(int storageNumber) {
        this.storageNumber = storageNumber;
    }

    public int getPrepareNumber() {
        return prepareNumber;
    }

    public void setPrepareNumber(int prepareNumber) {
        this.prepareNumber = prepareNumber;
    }

    public int getFemaleNumber() {
        return femaleNumber;
    }

    public void setFemaleNumber(int femaleNumber) {
        this.femaleNumber = femaleNumber;
    }

    public int getMinorityNumber() {
        return minorityNumber;
    }

    public void setMinorityNumber(int minorityNumber) {
        this.minorityNumber = minorityNumber;
    }

    public int getCollegeNumber() {
        return collegeNumber;
    }

    public void setCollegeNumber(int collegeNumber) {
        this.collegeNumber = collegeNumber;
    }
}
