package com.training.sgorodecki.homework.homework17.pages;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/error", name = "Error")
public class ErrorPage extends HttpServlet{
    private static final String ERROR_JSP = "WEB-INF/views/ErrorPage.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher(ERROR_JSP).forward(request,response);
    }
}
