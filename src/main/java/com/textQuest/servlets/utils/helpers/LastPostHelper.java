package com.textQuest.servlets.utils.helpers;

import com.textQuest.model.GameEngine;
import com.textQuest.model.GameFactory;
import com.textQuest.model.scene.SceneType;
import com.textQuest.model.state.GameState;
import com.textQuest.servlets.utils.StepToken;
import com.textQuest.servlets.utils.history.GameHistory;
import com.textQuest.servlets.utils.history.SessionGameHistory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public final class LastPostHelper {
    private static final Logger log = LoggerFactory.getLogger(LastPostHelper.class);
    private final GameHistory history;

    public LastPostHelper() {
        this.history = new SessionGameHistory();
    }
    public LastPostHelper(GameHistory gameHistory) {
        this.history = gameHistory;
    }

    public void redirectEndGame(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession(false);
        if (session == null) {
            log.warn("Session not found. Redirect => main");
            resp.sendRedirect(req.getContextPath() + "/main");
            return;
        }

        StepToken.validateToken(session, req.getParameter("stepToken"));

        GameEngine game = (GameEngine) session.getAttribute("game");
        SceneType result = null;
        if (game != null) {
            GameState state = game.currentState();
            result = (state != null) ? state.sceneType() : null;
        }

        String logResult;
        if (result == SceneType.WIN) logResult = "Win";
        else if (result == SceneType.LOSE) logResult = "Lose";
        else logResult = "Undefined";

        String action = req.getParameter("action");

        if("restart".equals(action)){
            if (history != null) history.clearGameHistory(session);
            else session.setAttribute("history", new ArrayList<String>());
            session.setAttribute("game", GameFactory.newGame());
            StepToken.setToken(session);

            log.info("{}. Game will be restarted. History cleared, new game started.", logResult);

            resp.sendRedirect(req.getContextPath() + "/game");
            return;
        }

        if (history != null) history.clearGameHistory(session);
        else session.setAttribute("history", new ArrayList<String>());
        log.info("{}. Session ended, history cleared", logResult);

        try {
            session.invalidate();
        } catch (IllegalStateException e) {
        }
        resp.sendRedirect(req.getContextPath() + "/main");
    }
}
