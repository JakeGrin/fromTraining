package com.training.sgorodecki.homework.homework20.interceptors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Component
public class AgreementInterceptor implements HandlerInterceptor {

    private static final Logger LOG = LogManager.getLogger(AgreementInterceptor.class);
    private static final String CHECKED = "checked";
    private static final String ERROR_PATH = "/error";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if (Objects.nonNull(session.getAttribute(CHECKED))) {
            return true;
        } else {
            response.sendRedirect(request.getContextPath() + ERROR_PATH);
            LOG.debug("the agreement has not been checked");
        }
        return false;
    }
}
