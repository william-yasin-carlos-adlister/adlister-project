package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class MySQLUsersDao implements Users {
    private Connection connection;

    public MySQLUsersDao(Config config) {
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
    public User findByUsername(String username) {
        String query = "SELECT * FROM users WHERE username = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            return extractUser(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by username", e);
        }
    }

    @Override
    public Long insert(User user) {
        String query = "INSERT INTO users(username, email, password) VALUES (?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating new user", e);
        }
    }

    private User extractUser(ResultSet rs) throws SQLException {
        if (!rs.next()) {
            return null;
        }
        return new User(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getString("email"),
                rs.getString("password")
        );
    }


    public void DeleteUserById(long id) {
        try {
            String insertQuery = "DELETE FROM users WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(insertQuery); //connection
            stmt.setLong(1, id);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting user.", e);
        }
    }


    public Long updateUser(User user) {
        String updateQuery = "UPDATE users SET username = ?, email = ? WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(updateQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setLong(3, user.getId());
            stmt.executeUpdate();
            return user.getId();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating user", e);
        }
    }


//    public User getUserById(long id) {
//        try {
//            String insertQuery = "SELECT * FROM ads WHERE id = ? LIMIT 1";
//            PreparedStatement stmt = connection.prepareStatement(insertQuery); //for connection
//            stmt.setLong(1,id);
//            ResultSet rs = stmt.executeQuery();
//            while (rs.next()) {
//                return extractUser(rs);
//            }
//            return null;
//        } catch (SQLException e) {
//            throw new RuntimeException("Error retrieving username.", e);
//        }
//    }

}
