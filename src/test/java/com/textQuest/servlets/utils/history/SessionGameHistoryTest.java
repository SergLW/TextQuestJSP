package com.textQuest.servlets.utils.history;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SessionGameHistoryTest {

    private HttpSession session;
    private Map<String, Object> map;

    @BeforeEach
    void setUp() {
        session = mock(HttpSession.class);
        map = new HashMap<String, Object>();

        when(session.getAttribute(anyString())).thenAnswer(inv -> map.get(inv.getArguments()[0]));
        doAnswer(inv -> {
           map.put((String)  inv.getArguments()[0],inv.getArguments()[1]);
           return null;
        }).when(session).setAttribute(anyString(), any());
    }

    @Test
    void addGetClear() {
        SessionGameHistory history = new SessionGameHistory();
        assertTrue(history.getGameHistory(session).isEmpty());

        history.addGameHistory(session, "\"Q1?\" → Так");
        history.addGameHistory(session, "\"Q2?\" → Ні");

        List<String> list = history.getGameHistory(session);
        assertEquals(2, list.size());
        assertTrue(list.get(0).contains("Q1"));
        assertTrue(list.get(1).contains("Q2"));

        history.clearGameHistory(session);
        assertTrue(history.getGameHistory(session).isEmpty());
    }

}