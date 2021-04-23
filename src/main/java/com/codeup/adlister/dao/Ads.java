package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.util.List;

public interface Ads {


    // get a list of all the ads
    List<Ad> all();
    // insert a new ad and return the new ad's id
    Long insert(Ad ad);

    Long updateAd(Ad ad);

    Ad getById(long id);

    void deleteAd(long id);

    List<Ad> searchAdsByTitle(String title);

    List<Ad> adsByUserId(long userId);
}
