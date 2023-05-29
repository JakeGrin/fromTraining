package com.training.sgorodecki.homework.homework17.pages;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/start", name = "Start")
public class StartPage extends HttpServlet {

    private static final String USERNAME = "username";
    private static final String CHECKED = "checked";
    private static final String CONSUMER_PAGE = "/consumer";
    private static final String START_JSP = "WEB-INF/views/StartPage.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher(START_JSP).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter(USERNAME);
        String checked = request.getParameter(CHECKED);
        session.setAttribute(USERNAME, username);
        session.setAttribute(CHECKED, checked);
        response.sendRedirect(request.getContextPath() + CONSUMER_PAGE);
    }
}