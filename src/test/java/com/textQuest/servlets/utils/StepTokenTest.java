package com.textQuest.servlets.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StepTokenTest {

    @Test
    void tokenLifecycle() {
        HttpSession session = mock(HttpSession.class);
        Map<String, Object> map = new HashMap<>();

        when(session.getAttribute(anyString())).thenAnswer(i -> map.get(i.getArguments()[0]));
        doAnswer(i -> {
            map.put((String)  i.getArguments()[0], i.getArguments()[1]);
            return null;
        }).when(session).setAttribute(anyString(), any());

        doAnswer(i -> {
            map.remove((String)  i.getArguments()[0]);
            return null;
        }).when(session).removeAttribute(anyString());

        StepToken.setToken(session);
        String token1 = StepToken.peek(session);
        assertNotNull(token1);

        assertDoesNotThrow(() -> StepToken.validateToken(session, token1));
        assertThrows(IllegalStateException.class, () -> StepToken.validateToken(session, "bad_token"));

        StepToken.setToken(session);
        String token2 = StepToken.peek(session);
        assertNotEquals(token1, token2);
        StepToken.clearToken(session);
        assertNull(StepToken.peek(session));
    }

}