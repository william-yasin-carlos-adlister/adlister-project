package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Album;
import com.codeup.adlister.models.Artist;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAlbumsDao implements Albums {

    private Connection connection = null;

    public MySQLAlbumsDao(Config config) {
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


    private Album extractAlbum(ResultSet rs) throws SQLException {
        return new Album(
                rs.getLong("id"),
                rs.getString("title"),
                rs.getLong("artist_id"),
                rs.getDouble("price")
        );
    }

    private List<Album> createAlbumsFromResults(ResultSet rs) throws SQLException {
        List<Album> albums = new ArrayList<>();
        while (rs.next()) {
            albums.add(extractAlbum(rs));
        }
        return albums;
    }


    public List<Album> searchAlbumsByTitle(String title) {
        PreparedStatement stmt = null;
        String sqlSearch = "SELECT * FROM albums WHERE title LIKE ?";
        title = "%" + title + "%";
        try {
            stmt = connection.prepareStatement(sqlSearch);
            stmt.setString(1, title);
            ResultSet rs = stmt.executeQuery();
            return createAlbumsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving ads search by title.", e);
        }
    }


    public Long insert(Album album) {
        Artist artist = new Artist();
        try {
            String insertQuery = "INSERT INTO albums(title, price) VALUES (?, ?)";
            String updateQuery = "UPDATE albums SET artist_id = replace(artist_id, (SELECT name FROM artists where name = ?), null)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement stmt1 = connection.prepareStatement(updateQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, album.getTitle());
            stmt.setDouble(2, album.getPrice());
            stmt1.setString(1, artist.getName());
            stmt.executeUpdate();
            stmt1.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }


    }




}
