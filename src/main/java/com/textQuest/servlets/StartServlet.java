package com.textQuest.servlets;

import com.textQuest.model.GameEngine;
import com.textQuest.model.GameFactory;
import com.textQuest.servlets.utils.StepToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="StartServlet", value = "/main")
public class StartServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(StartServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);

        GameEngine game = GameFactory.newGame();
        session.setAttribute("game", game);
        session.setAttribute("history", new ArrayList<String>());

        StepToken.setToken(session);

        log.info("Game Started");

        resp.sendRedirect(req.getContextPath() + "/game");
    }
}
