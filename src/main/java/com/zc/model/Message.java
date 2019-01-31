package com.zc.model;

import java.util.Date;

public class Message {

    private String id;
    private String context;
    private String username;
    private String sendDate;
    private String code;

    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                ", context='" + context + '\'' +
                ", username='" + username + '\'' +
                ", sendDate=" + sendDate +
                ", code='" + code + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
