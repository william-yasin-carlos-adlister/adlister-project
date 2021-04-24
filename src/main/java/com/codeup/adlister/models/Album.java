package com.codeup.adlister.models;

public class Album {

    private long id;
    private String title;
    private long artistID;
    private double price;


    public Album(long id, String title, long artistID, double price) {

        this.id = id;
        this.title = title;
        this.artistID = artistID;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getArtistID() {
        return artistID;
    }

    public void setArtistID(long artistID) {
        this.artistID = artistID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
