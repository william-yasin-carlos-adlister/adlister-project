package com.codeup.adlister.dao;

import com.codeup.adlister.models.Artist;

import java.util.List;

public interface Artists {

    List<Artist> searchArtistsByName(String name);
    Long insert(Artist artist);
}
