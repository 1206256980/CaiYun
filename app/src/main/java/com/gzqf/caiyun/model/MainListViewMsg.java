package com.gzqf.caiyun.model;

public class MainListViewMsg {

    private String city;
    private String title;
    private String content;

    public MainListViewMsg(String city, String title, String content) {
        this.city = city;
        this.title = title;
        this.content = content;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
