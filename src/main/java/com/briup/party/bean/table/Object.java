package com.briup.party.bean.table;

public class Object {
    private Short id;

    private String name;

    private String time;

    private String address;

    private String teacher;

    private String host;

    private String recoder;

    private Short due;

    private Short attendence;

    private String content;

    private String urlNote;

    private Short userId;

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher == null ? null : teacher.trim();
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host == null ? null : host.trim();
    }

    public String getRecoder() {
        return recoder;
    }

    public void setRecoder(String recoder) {
        this.recoder = recoder == null ? null : recoder.trim();
    }

    public Short getDue() {
        return due;
    }

    public void setDue(Short due) {
        this.due = due;
    }

    public Short getAttendence() {
        return attendence;
    }

    public void setAttendence(Short attendence) {
        this.attendence = attendence;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getUrlNote() {
        return urlNote;
    }

    public void setUrlNote(String urlNote) {
        this.urlNote = urlNote == null ? null : urlNote.trim();
    }

    public Short getUserId() {
        return userId;
    }

    public void setUserId(Short userId) {
        this.userId = userId;
    }
}