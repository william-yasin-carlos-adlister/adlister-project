package com.codeup.adlister.models;

public class Album {

    private long id;
    private String title;
    private long artistID;
    private double price;
    private Artist artist;

    public Album(){}

    public Album(long id, String title, long artistID, double price) {
        this.id = id;
        this.title = title;
        this.artistID = artistID;
        this.price = price;
    }

    public Album(long id, String title, double price, Artist artist) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.artist = artist;
    }

    public Album(long id, String title, double price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public Album(String title,long artistID, double price) {
        this.title = title;
        this.artistID = artistID;
        this.price = price;
    }
    public Album(String title, double price) {

        this.title = title;
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

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
}
