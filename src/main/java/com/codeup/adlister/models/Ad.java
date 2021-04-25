package com.codeup.adlister.models;

public class Ad {
    private long id;
    private long userId;
    private String adTitle;
    private String description;

    public Ad(long id, long userId, String adTitle, String description) {
        this.id = id;
        this.userId = userId;
        this.adTitle = adTitle;
        this.description = description;
    }

    public Ad(long userId, String adTitle, String description) {
        this.userId = userId;
        this.adTitle = adTitle;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getAdTitle() {
        return adTitle;
    }

    public void setAdTitle(String adTitle) {
        this.adTitle = adTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
