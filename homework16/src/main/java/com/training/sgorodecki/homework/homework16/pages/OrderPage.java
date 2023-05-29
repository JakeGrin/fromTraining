package com.training.sgorodecki.homework.homework16.pages;

import com.training.sgorodecki.homework.homework16.services.BucketService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/order", name = "Order")
public class OrderPage extends HttpServlet {
    private final BucketService bucketService = BucketService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();

        String orderPage = "<html>" +
                "<body>" +
                "<div>" +
                "<p>" +
                "<br><br>" +
                "<h1 align=center><b> Dear " + session.getAttribute("username") + ", your order:" + " </b><h1>" +
                "<div align=center><ol>" + bucketService.makeUserBucket((String) session.getAttribute("username")) + "</ol></div>" +
                "<h2 align=center><b> Total:" + bucketService.makeTotalCost((String) session.getAttribute("username")) + '$' + " </h2>" +
                "</div>" +
                "</body> " +
                "</html>";

        try (PrintWriter writer = resp.getWriter()) {
            writer.println(orderPage);
        }
        resp.getWriter().println(orderPage);
    }
}
