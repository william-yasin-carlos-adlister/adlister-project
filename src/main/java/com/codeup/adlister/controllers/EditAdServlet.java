package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ads/edit")
public class EditAdServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") == null) {
            resp.sendRedirect("/login");
            return;
        }

        long id = Long.parseLong(req.getParameter("id"));
        req.setAttribute("ad", DaoFactory.getAdsDao().getById(id));

        req.getRequestDispatcher("/WEB-INF/ads/edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = (User) req.getSession().getAttribute("user");

        long id = Long.parseLong(req.getParameter("id"));
        String title = req.getParameter("title");
        String description =  req.getParameter("description");

        Ad updatedAd = new Ad(id, user.getId(), title, description);

//        DaoFactory.getAdsDao().updateAd(updatedAd);

        resp.sendRedirect("/details?id=" + id);
    }
}
