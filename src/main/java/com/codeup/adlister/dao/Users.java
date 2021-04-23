package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

import java.util.List;

public interface Users {
    User findByUsername(String username);
    Long insert(User user);
//    public User getUserById(long id);
    void DeleteUserById(long id);
    Long updateUser(User user);
}
