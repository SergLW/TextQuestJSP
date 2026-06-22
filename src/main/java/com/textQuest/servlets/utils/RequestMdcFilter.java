package com.textQuest.servlets.utils;

import org.slf4j.MDC;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class RequestMdcFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        try {
            HttpServletRequest request = (HttpServletRequest) req;
            HttpSession session = request.getSession(false);
            MDC.put("sid", (session != null) ? session.getId() : "-");
            MDC.put("ip", req.getRemoteAddr());
            chain.doFilter(req, resp);
        } finally {
            MDC.clear();
        }
    }
}
