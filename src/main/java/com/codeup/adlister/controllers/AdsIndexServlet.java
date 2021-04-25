package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// renamed to artist-results from search-results and added another servlet with album-results
@WebServlet(name = "controllers.AdsIndexServlet", urlPatterns = "/artist-results")
public class AdsIndexServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String artistName = request.getParameter("artist");

        // Hit DAO access object MySQLArtistDao to search by artist
            request.setAttribute("artist", DaoFactory.getArtistsDao().searchArtistsByName(artistName));
            request.getRequestDispatcher("/WEB-INF/ads/search-results.jsp").forward(request, response);


    }

}
