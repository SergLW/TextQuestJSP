package com.textQuest.servlets.utils;

import javax.servlet.http.HttpSession;
import java.util.UUID;

public final class StepToken {
    private final static String KEY = "stepToken";

    private StepToken() {}

    public static void setToken(HttpSession session) {
        session.setAttribute(KEY, UUID.randomUUID().toString());
    }

    public static void validateToken(HttpSession session, String token) {
        String expectedToken = (String) session.getAttribute(KEY);
        if (!expectedToken.equals(token) || expectedToken == null || token == null) {
            throw new IllegalStateException("Invalid token");
        }
    }

    public static void clearToken(HttpSession session) {
        session.removeAttribute(KEY);
    }

    public static String peek(HttpSession session) {
        return (String) session.getAttribute(KEY);
    }
}
