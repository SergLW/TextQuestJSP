package com.textQuest.servlets.utils.helpers;

import com.textQuest.model.GameEngine;
import com.textQuest.model.scene.SceneType;
import com.textQuest.model.state.GameState;
import com.textQuest.model.state.QuestionState;
import com.textQuest.servlets.utils.history.GameHistory;
import org.slf4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public final class PostHelper {
    private final GameHistory gameHistory;
    private final Logger logger;

    public PostHelper(GameHistory gameHistory, Logger logger) {
        this.gameHistory = gameHistory;
        this.logger = logger;
    }

    public HttpSession checkActiveSession(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("game") == null) {
            resp.sendRedirect(req.getContextPath() + "/main");
            return null;
        }
        return session;
    }

    public boolean parseAnswer(HttpServletRequest req) {
        return "true".equalsIgnoreCase(req.getParameter("answer"));
    }

    public String choiceLabel(GameState beforeState, boolean isTrue) {
        if (beforeState instanceof QuestionState) {
            QuestionState questionState = (QuestionState) beforeState;
            return isTrue ? questionState.trueLabel() : questionState.falseLabel();
        }
        return isTrue ? "Tak" : "Hi";
    }

    public void addHistory(HttpSession session, GameState beforeState, String chosenLabel) {
        if (beforeState instanceof QuestionState) {
            gameHistory.addGameHistory(session, "\"" + beforeState.text() + "\" -> " +  chosenLabel);
        }
    }

    public void redirectNext(HttpServletRequest req, HttpServletResponse resp, GameEngine game) throws IOException {
        SceneType sceneType = game.currentState().sceneType();
        String nextLink;
        if (sceneType == SceneType.QUESTION) {
            nextLink = "/game";
        } else if (sceneType == SceneType.WIN) {
            nextLink = "/win";
        } else {
            nextLink = "/lose";
        }
        resp.sendRedirect(req.getContextPath() + nextLink);
    }
}
