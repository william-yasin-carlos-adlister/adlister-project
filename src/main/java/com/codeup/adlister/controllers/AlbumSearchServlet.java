package com.codeup.adlister.controllers;


import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.AdsIndexServlet", urlPatterns = "/album-results")
public class AlbumSearchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String albumTitle = req.getParameter("title");

        req.setAttribute("albums", DaoFactory.getAlbumsDao().searchAlbumsByTitle(albumTitle));
        req.getRequestDispatcher("/WEB-INF/ads/search-results.jsp").forward(req, resp);


    }


}
