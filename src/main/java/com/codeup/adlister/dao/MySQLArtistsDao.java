package com.codeup.adlister.dao;

import com.codeup.adlister.models.Artist;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLArtistsDao implements Artists {

    private Connection connection = null;

    public MySQLArtistsDao(Config config) {
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


    private Artist extractArtist(ResultSet rs) throws SQLException {
        return new Artist(
                rs.getLong("id"),
                rs.getString("name")
        );
    }

    private List<Artist> createArtistsFromResults(ResultSet rs) throws SQLException {
        List<Artist> artists = new ArrayList<>();
        while (rs.next()) {
            artists.add(extractArtist(rs));
        }
        return artists;
    }


    public List<Artist> searchArtistsByName(String name) {
        PreparedStatement stmt = null;
        String sqlSearch = "SELECT * FROM artists WHERE name LIKE ?";
        name = "%" + name + "%";
        try {
            stmt = connection.prepareStatement(sqlSearch);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            return createArtistsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving ads search by title.", e);
        }
    }


}
