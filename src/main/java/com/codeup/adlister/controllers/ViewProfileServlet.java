package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.ViewProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Started code logic to allow visitors to view other users ads on their profile page with jsp view logic
//        if (request.getSession().getAttribute("user") == null) {
//            long id = Long.parseLong(request.getParameter("userId"));
//            request.setAttribute("ads", DaoFactory.getAdsDao().adsByUserId(id));
//            request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
//        }


        User loggedInUser = (User) request.getSession().getAttribute("user");

        request.setAttribute("ads", DaoFactory.getAdsDao().adsByUserId(loggedInUser.getId()));
        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        DaoFactory.getUsersDao().DeleteUserById(id);
        req.getSession().invalidate(); //ends the session
        resp.sendRedirect("/register");

        // /// //
        String titleSearch = req.getParameter("search-title");

        DaoFactory.getAdsDao().searchAdsByTitle(titleSearch);
        resp.sendRedirect("/search-results?title=" + titleSearch);

    }
}
