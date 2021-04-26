package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Album;
import com.codeup.adlister.models.Artist;
import com.mysql.cj.jdbc.Driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;

    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public List<Ad> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM wax_ads");
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public Long insert(Ad ad) {
        try {
            String insertQuery = "INSERT INTO wax_ads(user_id, ad_title, artist_id, album_id, description) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getAdTitle());
            stmt.setLong(3, ad.getArtistId());
            stmt.setLong(4, ad.getAlbumId());
            stmt.setString(5, ad.getDescription());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    @Override
    public Long updateAd(Ad ad) {
        String updateQuery = "UPDATE wax_ads SET ad_title = ?, description = ? WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(updateQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, ad.getAdTitle());
            stmt.setString(2, ad.getDescription());
            stmt.setLong(3, ad.getId());
            stmt.executeUpdate();
            return ad.getId();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating ad", e);
        }
    }


    private Ad extractAd(ResultSet rs) throws SQLException {
        return new Ad(
                rs.getLong("ad.id"),
                rs.getLong("ad.user_id"),
                rs.getString("ad.ad_title"),
                rs.getLong("ad.album_id"),
                rs.getString("ad.description"),
                new Album(
                        rs.getLong("al.id"),
                        rs.getString("al.title"),
                        rs.getDouble("al.price"),
                        new Artist(
                                rs.getLong("ar.id"),
                                rs.getString("ar.name")
                        )
                ));
    }

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }

    public Ad getById(long id) {
        try {
            String insertQuery = "SELECT ad.*, al.*, ar.* FROM wax_ads ad JOIN albums al ON ad.album_id = al.id JOIN artists ar ON ar.id = al.artist_id WHERE ad.id = ?";
            // select ads.*, albums.*, artists.* JOIN... WHERE id = ?
            PreparedStatement stmt = connection.prepareStatement(insertQuery); //for connection
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return extractAd(rs);
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving ad.", e);
        }
    }

    public void deleteAd(long id) {

        try {
            String deleteQuery = "DELETE FROM wax_ads WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(deleteQuery);
            stmt.setLong(1, id);
            stmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException("Error deleting ad", e);
        }

    }

    public List<Ad> searchAdsByTitle(String title) {
        PreparedStatement stmt = null;
        String sqlSearch = "SELECT * FROM wax_ads WHERE title LIKE ?";
        title = "%" + title + "%";
        try {
            stmt = connection.prepareStatement(sqlSearch);
            stmt.setString(1, title);
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving ads search by title.", e);
        }
    }

    public List<Ad> adsByUserId(long userId) {
        String searchSql = "SELECT ad.*, al.*, ar.* FROM wax_ads ad JOIN albums al ON ad.album_id = al.id JOIN artists ar ON ar.id = al.artist_id WHERE ad.user_id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(searchSql);
            stmt.setLong(1, userId);
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error finding ads by userId.", e);
        }
    }


}
