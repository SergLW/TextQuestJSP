package com.textQuest.servlets.utils.helpers;

import com.textQuest.model.state.GameState;
import com.textQuest.model.state.QuestionState;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

public final class GetHelper {

    public HttpSession checkActiveSession(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("game") == null) {
            resp.sendRedirect(req.getContextPath() + "/main");
            return null;
        }
        return session;
    }

    public void getQuestionView(HttpServletRequest req, GameState state) {
        req.setAttribute("state", state);
        if (state instanceof QuestionState) {
            QuestionState questionState = (QuestionState) state;
            req.setAttribute("trueLabel", questionState.trueLabel());
            req.setAttribute("falseLabel", questionState.falseLabel());
        } else {
            req.setAttribute("trueLabel", "Так");
            req.setAttribute("falseLabel", "Hi");
        }
    }
}
