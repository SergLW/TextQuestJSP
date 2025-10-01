package com.textQuest.servlets;

import com.textQuest.model.scene.SceneType;
import com.textQuest.servlets.utils.helpers.LastGetHelper;
import com.textQuest.servlets.utils.helpers.LastPostHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoseGameServlet", value = "/lose")
public class LoseGameServlet extends HttpServlet {
    private final LastGetHelper lastGetHelper = new LastGetHelper();
    private final LastPostHelper lastPostHelper = new LastPostHelper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = lastGetHelper.redirectEndGame(req, resp, SceneType.LOSE);
        if (session == null) return;

        req.getRequestDispatcher("/WEB-INF/jsp/lose.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        lastPostHelper.redirectEndGame(req, resp);
    }
}
