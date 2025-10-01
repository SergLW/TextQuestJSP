package com.textQuest.servlets.utils.history;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SessionGameHistory implements GameHistory {
    private static final String KEY = "history";

    @Override
    public void addGameHistory(HttpSession session, String line) {
       List<String> list = getOrCreateList(session);
       list.add(line);
    }

    @Override
    public void clearGameHistory(HttpSession session) {
        session.setAttribute(KEY, new  ArrayList<String>());
    }

    @Override
    public List<String> getGameHistory(HttpSession session) {
        List<String> list = (List<String>) session.getAttribute(KEY);
        return list == null ? Collections.<String>emptyList() : Collections.unmodifiableList(list);
    }

    @SuppressWarnings("unchecked")
    private List<String> getOrCreateList(HttpSession session) {
        List<String> list = (List<String>) session.getAttribute(KEY);
        if (list == null) {
            list = new ArrayList<>();
            session.setAttribute(KEY, list);
        }
        return list;
    }
}
