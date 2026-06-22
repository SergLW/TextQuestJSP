package com.textQuest.servlets;

import com.textQuest.model.GameEngine;
import com.textQuest.model.state.GameState;
import com.textQuest.model.state.QuestionState;
import com.textQuest.servlets.utils.StepToken;
import com.textQuest.servlets.utils.helpers.GetHelper;
import com.textQuest.servlets.utils.helpers.PostHelper;
import com.textQuest.servlets.utils.history.GameHistory;
import com.textQuest.servlets.utils.history.SessionGameHistory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "QuestionsServlet", value = "/game")
public class QuestionsServlet extends HttpServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(QuestionsServlet.class);

    private final GameHistory history;
    private final PostHelper postHelper;
    private final GetHelper getHelper;

    public QuestionsServlet() {
        this(new SessionGameHistory());
    }
    public QuestionsServlet(GameHistory history) {
        this.history = history;
        this.postHelper = new PostHelper(history, LOGGER);
        this.getHelper = new GetHelper();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = getHelper.checkActiveSession(req, resp);
        if (session == null) return;

        GameEngine game = (GameEngine) session.getAttribute("game");
        GameState state = game.currentState();

        getHelper.getQuestionView(req, state);

        req.getRequestDispatcher("/WEB-INF/jsp/game.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = postHelper.checkActiveSession(req, resp);
        if (session == null) return;

        StepToken.validateToken(session, req.getParameter("stepToken"));

        GameEngine game = (GameEngine) session.getAttribute("game");
        GameState beforeState = game.currentState();

        boolean isTrue = postHelper.parseAnswer(req);
        String chosenLabel = postHelper.choiceLabel(beforeState, isTrue);

        game.answer(isTrue);
        postHelper.addHistory(session, beforeState, chosenLabel);
        StepToken.setToken(session);
        postHelper.redirectNext(req, resp, game);
    }
}
