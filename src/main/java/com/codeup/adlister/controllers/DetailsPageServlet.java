package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.MySQLAdsDao;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Album;
import com.codeup.adlister.models.Artist;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.DetailsPageServlet", urlPatterns = "/details")
public class DetailsPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        long id = Long.parseLong(req.getParameter("id"));
        String artistName = req.getParameter("artistName");
        String albumName = req.getParameter("albumName");
        Ad ad = DaoFactory.getAdsDao().getById(id);
//        Artist artist = DaoFactory.getArtistsDao().searchArtistsByName(artistName);
//        Album album = DaoFactory.getAlbumsDao().searchAlbumsByTitle(albumName);
        try {
            req.setAttribute("ad", ad);
//            req.setAttribute("artist", artist);
//            req.setAttribute("album", album);
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("/WEB-INF/ads/details-page.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        long id = Long.parseLong(req.getParameter("id"));


        DaoFactory.getAdsDao().deleteAd(id);

        resp.sendRedirect("/profile?userId=" + id);
    }

}
