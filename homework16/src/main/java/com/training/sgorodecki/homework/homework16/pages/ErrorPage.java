package com.training.sgorodecki.homework.homework16.pages;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/error", name = "Error")
public class ErrorPage extends HttpServlet{
    public static final String ERROR = "<html>" +
            "<body>" +
            "<div>" +
            "<p>" +
            "<h1 align=center><b> Oops!  </b></h1>" +
            "<br><br>" +
            "<h1 align=center><b> You shouldn't be here  </b></h1>" +
            "<br><br>" +
            "<h1 align=center><b> Please,agree with the terms of service first  </b></h1>" +
            "<br><br><br>" +
            "<h1 align=center><a href =/start>Start page</a></h1>"+
            "</div>" +
            "</body> " +
            "</html>";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        try (PrintWriter writer = response.getWriter()) {
            writer.println(ERROR);
        }
    }

}
