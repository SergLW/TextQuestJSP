package com.textQuest.servlets.utils.helpers;

import com.textQuest.model.GameEngine;
import com.textQuest.model.scene.SceneType;
import com.textQuest.model.state.GameState;
import com.textQuest.servlets.utils.StepToken;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public final class LastGetHelper {

    public HttpSession redirectEndGame(HttpServletRequest req, HttpServletResponse resp, SceneType scene) throws IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("game") == null) {
            resp.sendRedirect(req.getContextPath() + "/main");
            return null;
        }

        GameEngine game = (GameEngine) session.getAttribute("game");
        GameState state = game.currentState();

        if (state == null || state.sceneType() != scene) {
            resp.sendRedirect(req.getContextPath() + "/main");
            return null;
        }

        req.setAttribute("state", state);
        StepToken.setToken(session);
        return  session;
    }

}
