package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.Albums;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Album;
import com.codeup.adlister.models.Artist;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/ads/create")
public class CreateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/ads/create.jsp")
            .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        Artist artist = new Artist(
                request.getParameter("artist_name")
        );
        DaoFactory.getArtistsDao().insert(artist);

        Double price = Double.parseDouble(request.getParameter("price"));

        Album album = new Album(
                request.getParameter("album_title"),
                price
        );
        DaoFactory.getAlbumsDao().insert(album);

        Ad ad = new Ad(
                user.getId(),
                request.getParameter("ad_title"),
                request.getParameter("description")
        );
        DaoFactory.getAdsDao().insert(ad);

        response.sendRedirect("/");
    }
}
