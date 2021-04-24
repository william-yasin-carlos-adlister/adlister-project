package com.codeup.adlister.dao;

import com.codeup.adlister.models.Album;

import java.util.List;

public interface Albums {

    List<Album> searchAlbumsByTitle(String title);
}
