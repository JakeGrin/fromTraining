package com.training.sgorodecki.homework.homework17.pages;

import com.training.sgorodecki.homework.homework17.services.BucketService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/order", name = "Order")
public class OrderPage extends HttpServlet {
    private static final String USERNAME = "username";
    private static final String ORDER_JSP = "WEB-INF/views/OrderPage.jsp";
    private static final String USER_BUCKET = "userBucket";
    private static final String TOTAL_COST = "totalCost";
    private final BucketService bucketService = BucketService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute(USERNAME);
        req.setAttribute(USER_BUCKET, bucketService.makeUserBucket(username));
        req.setAttribute(TOTAL_COST, bucketService.makeTotalCost(username));
        req.getRequestDispatcher(ORDER_JSP).forward(req, resp);
    }
}