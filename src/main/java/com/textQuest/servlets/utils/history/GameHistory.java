package com.textQuest.servlets.utils.history;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface GameHistory {

    void addGameHistory(HttpSession session, String line);
    void clearGameHistory(HttpSession session);

    List<String> getGameHistory(HttpSession session);
}
