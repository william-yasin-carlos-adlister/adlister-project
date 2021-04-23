package com.codeup.adlister.controllers;


import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.SearchServlet", urlPatterns = "/")
public class SearchServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String titleSearch = req.getParameter("search-title");

        // execute search and redirect to /ads results jsp page
        DaoFactory.getAdsDao().searchAdsByTitle(titleSearch);
        resp.sendRedirect("/search-results?title=" + titleSearch);

    }


}
