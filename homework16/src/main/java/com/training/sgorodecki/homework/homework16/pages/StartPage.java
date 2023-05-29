package com.training.sgorodecki.homework.homework16.pages;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/start", name = "Start")
public class StartPage extends HttpServlet {

    String openPage = "<html>" +
            "<body>" +
            "<div>" +
            "<p>" +
            "<br><br>" +
            "<h2 align=center><b> Welcome to the Online Shop!</h2>" +
            "<br><br>" +
            "<h2 align=center>" +
            "<form action=\"/start\" method = \"post\">" +
            "<input type =\"text\" name =\"username\" placeholder=\"Enter your name\" size=\"40\" required=\"required\">" +
            "</h2><br>" +
            "<h5 align=center><label><input type=\"checkbox\" name=\"checked\"> " +
            "I agree with the terms of service</h5></label>" +
            "<h2 align=center><input type = \"submit\" value=\"Enter\"></h2>" +
            "</form>" +
            "</p>" +
            "</div>" +
            "</body> " +
            "</html>";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try (PrintWriter writer = response.getWriter()) {
            writer.println(openPage);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String checked = request.getParameter("checked");

        session.setAttribute("username", username);
        session.setAttribute("checked", checked);
        response.sendRedirect(request.getContextPath() + "/consumer");
    }
}