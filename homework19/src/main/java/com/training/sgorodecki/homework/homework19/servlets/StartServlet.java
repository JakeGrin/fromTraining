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

@WebServlet(value = "/start", name = "Start")
public class StartServlet extends HttpServlet {

    private static final String USERNAME = "username";
    private static final String CHECKED = "checked";
    private static final String CONSUMER_PAGE = "/consumer";
    private static final String START_JSP = "WEB-INF/views/StartPage.jsp";

    private UserService userService;
    private OrderService orderService;

    @Override
    public void init() {
        ClassPathXmlApplicationContext applicationContext =
                (ClassPathXmlApplicationContext) getServletContext().getAttribute("applicationContext");

        orderService = (OrderService) applicationContext.getBean("orderServiceImpl");
        userService = (UserService) applicationContext.getBean("userServiceImpl");
    }

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

        userService.addUser(username);
        orderService.addOrder(userService.getUserByLogin(username).getId());

        response.sendRedirect(request.getContextPath() + CONSUMER_PAGE);
    }
}