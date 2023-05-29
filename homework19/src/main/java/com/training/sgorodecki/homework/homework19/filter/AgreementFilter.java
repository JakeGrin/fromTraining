package com.training.sgorodecki.homework.homework19.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@WebFilter(urlPatterns = {"/consumer", "/order"})
public class AgreementFilter implements Filter {

    private static final Logger LOG = LogManager.getLogger(AgreementFilter.class);

    public void init(FilterConfig config) {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

        HttpServletResponse res = (HttpServletResponse) servletResponse;
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpSession session = req.getSession();
        if (Objects.isNull(session.getAttribute("checked"))) {
            LOG.debug("You didn't agree with terms");
            res.sendRedirect(req.getContextPath() + "/error");
        }
        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {
    }
}