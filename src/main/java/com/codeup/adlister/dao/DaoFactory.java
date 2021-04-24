package com.codeup.adlister.dao;

public class DaoFactory {
    private static Ads adsDao;
    private static Users usersDao;
    private static Albums albumsDao;
    private static Artists artistsDao;
    private static Config config = new Config();

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySQLAdsDao(config);
        }
        return adsDao;
    }

    public static Users getUsersDao() {
        if (usersDao == null) {
            usersDao = new MySQLUsersDao(config);
        }
        return usersDao;
    }

    public static Albums getAlbumsDao() {
        if (albumsDao == null) {
            albumsDao = new MySQLAlbumsDao(config);
        }
        return albumsDao;
    }

    public static Artists getArtistsDao() {
        if (artistsDao == null) {
            artistsDao = new MySQLArtistsDao(config);
        }
        return artistsDao;
    }



}
