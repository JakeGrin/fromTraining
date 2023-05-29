package com.training.sgorodecki.homework.homework19.servlets;

import com.training.sgorodecki.homework.homework19.services.api.GoodService;
import com.training.sgorodecki.homework.homework19.services.api.OrderService;
import com.training.sgorodecki.homework.homework19.services.api.UserService;
import com.training.sgorodecki.homework.homework19.services.impl.OrderServiceImpl;
import com.training.sgorodecki.homework.homework19.services.impl.UserServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/order", name = "Order")
public class OrderServlet extends HttpServlet {
    private static final String USERNAME = "username";
    private static final String ORDER_JSP = "WEB-INF/views/OrderPage.jsp";
    private static final String USER_BUCKET = "userBucket";
    private static final String TOTAL_COST = "totalCost";

    private OrderService orderService;
    private UserService userService;

    @Override
    public void init() {
        ClassPathXmlApplicationContext applicationContext =
                (ClassPathXmlApplicationContext) getServletContext().getAttribute("applicationContext");

        orderService = (OrderService) applicationContext.getBean("orderServiceImpl");
        userService = (UserService) applicationContext.getBean("userServiceImpl");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute(USERNAME);
        req.setAttribute(USER_BUCKET, orderService.getUserGoods(username));
        req.setAttribute(TOTAL_COST, orderService.getOrderByUserId(
                userService.getUserByLogin(username).getId()).getTotalPrice());

        req.getRequestDispatcher(ORDER_JSP).forward(req, resp);
    }

}