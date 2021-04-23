package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;

@WebServlet(name = "controllers.EditUserServlet", urlPatterns = "/edit-user")
public class EditUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") == null) {
            resp.sendRedirect("/login");
            return;
        }

        req.setAttribute("ads", DaoFactory.getAdsDao().all());
        req.getRequestDispatcher("/WEB-INF/users/edit-user.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");


        long id = Long.parseLong(req.getParameter("id"));
        String username = req.getParameter("username");
        String email = req.getParameter("email");

        //double check if user exists
        User checkExistingUsername = DaoFactory.getUsersDao().findByUsername(username);
        // validate input
        boolean inputHasErrors = username.isEmpty()
                || email.isEmpty()
                || checkExistingUsername != null;   // is checking if username already exist in db;

        if (inputHasErrors) {
            resp.sendRedirect("/edit-user");
            return;
        }



        User updateUser = new User(id, username, email, user.getPassword());
        DaoFactory.getUsersDao().updateUser(updateUser);

        req.getSession().setAttribute("user", updateUser);
        resp.sendRedirect("/profile");
    }
}
