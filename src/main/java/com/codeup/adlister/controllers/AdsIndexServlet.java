package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.AdsIndexServlet", urlPatterns = "/search-results")
public class AdsIndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Hit DAO access object MySQLAdsDao to search by title
        request.setAttribute("ads", DaoFactory.getAdsDao().searchAdsByTitle(request.getParameter("title")));
        request.getRequestDispatcher("/WEB-INF/ads/search-results.jsp").forward(request, response);
    }
}
