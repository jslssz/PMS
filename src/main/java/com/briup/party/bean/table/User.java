package com.briup.party.bean.table;

public class User {
    private Short id;

    private String username;

    private String password;

    private String name;

    private String idcard;

    private String gender;

    private String nation;

    private Byte age;

    private String category;

    private Double infocompleteness;

    private Short branchId;

    private Short dtlId;

    private Short etdId;

    public User(){}

    public User(Short id, String username, String password, String name, String idcard, String gender, String nation, Byte age, String category, Double infocompleteness, Short branchId, Short dtlId, Short etdId) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.idcard = idcard;
        this.gender = gender;
        this.nation = nation;
        this.age = age;
        this.category = category;
        this.infocompleteness = infocompleteness;
        this.branchId = branchId;
        this.dtlId = dtlId;
        this.etdId = etdId;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public Double getInfocompleteness() {
        return infocompleteness;
    }

    public void setInfocompleteness(Double infocompleteness) {
        this.infocompleteness = infocompleteness;
    }

    public Short getBranchId() {
        return branchId;
    }

    public void setBranchId(Short branchId) {
        this.branchId = branchId;
    }

    public Short getDtlId() {
        return dtlId;
    }

    public void setDtlId(Short dtlId) {
        this.dtlId = dtlId;
    }

    public Short getEtdId() {
        return etdId;
    }

    public void setEtdId(Short etdId) {
        this.etdId = etdId;
    }
}