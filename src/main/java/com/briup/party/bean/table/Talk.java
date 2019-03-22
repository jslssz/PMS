package com.briup.party.bean.table;

public class Talk {
    private Short id;

    private String name;

    private String time;

    private String address;

    private String speaker;

    private String speakerJob;

    private String listener;

    private String listenerJob;

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

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker == null ? null : speaker.trim();
    }

    public String getSpeakerJob() {
        return speakerJob;
    }

    public void setSpeakerJob(String speakerJob) {
        this.speakerJob = speakerJob == null ? null : speakerJob.trim();
    }

    public String getListener() {
        return listener;
    }

    public void setListener(String listener) {
        this.listener = listener == null ? null : listener.trim();
    }

    public String getListenerJob() {
        return listenerJob;
    }

    public void setListenerJob(String listenerJob) {
        this.listenerJob = listenerJob == null ? null : listenerJob.trim();
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