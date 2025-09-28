package com.textQuest.servlets.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class StepTokenFilter implements Filter {
    private static final Logger log = LoggerFactory.getLogger(StepTokenFilter.class);
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        if ("POST".equalsIgnoreCase(request.getMethod())) {
            HttpSession session = request.getSession(false);
            String expectedToken = (session != null) ? StepToken.peek(session) : null;
            String providedToken = request.getParameter("stepToken");
            if (session == null || expectedToken == null || providedToken == null || !expectedToken.equals(providedToken)) {
                log.warn("Invalid Step Token (expected={}, provided={})", expectedToken, providedToken);
                response.sendRedirect(request.getContextPath() + "/main");
                return;
            }
        }
        chain.doFilter(req, resp);
    }
}
