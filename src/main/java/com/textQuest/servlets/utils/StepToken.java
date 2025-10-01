package com.textQuest.servlets.utils;

import com.textQuest.exceptions.InvalidTokenException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSession;
import java.util.UUID;

public final class StepToken {
    private final static String KEY = "stepToken";
    private static final Logger log = LoggerFactory.getLogger(StepToken.class);

    private StepToken() {}

    public static void setToken(HttpSession session) {
        session.setAttribute(KEY, UUID.randomUUID().toString());
    }

    public static void validateToken(HttpSession session, String token) {
        String expectedToken = (String) session.getAttribute(KEY);
        if (expectedToken == null || token == null || !expectedToken.equals(token)) {
            log. warn("Invalid Step Token (expected={}, provided={})",  expectedToken, token);
            throw new InvalidTokenException(expectedToken, token);
        }
    }

    public static void clearToken(HttpSession session) {
        session.removeAttribute(KEY);
    }

    public static String peek(HttpSession session) {
        return (String) session.getAttribute(KEY);
    }
}
