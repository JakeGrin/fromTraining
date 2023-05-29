package com.training.sgorodecki.homework.homework19.servlets;

import com.training.sgorodecki.homework.homework19.entity.Good;
import com.training.sgorodecki.homework.homework19.entity.Order;
import com.training.sgorodecki.homework.homework19.services.api.GoodService;
import com.training.sgorodecki.homework.homework19.services.api.OrderService;
import com.training.sgorodecki.homework.homework19.services.api.UserService;
import com.training.sgorodecki.homework.homework19.services.impl.GoodServiceImpl;
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

@WebServlet(value = "/consumer", name = "Consumer")
public class ConsumerServlet extends HttpServlet {

    private static final String USERNAME = "username";
    private static final String CURRENT_USER_BUCKET = "currentUserBucket";
    private static final String MAKE_GOOD_LIST = "makeGoodList";
    private static final String CONSUMER = "/consumer";
    private static final String ID = "id";
    private static final String CONSUMER_JSP = "WEB-INF/views/ConsumerPage.jsp";

    private OrderService orderService;
    private GoodService goodService;
    private UserService userService;

    @Override
    public void init() {
        ClassPathXmlApplicationContext applicationContext =
                (ClassPathXmlApplicationContext) getServletContext().getAttribute("applicationContext");

        orderService = (OrderService) applicationContext.getBean("orderServiceImpl");
        goodService = (GoodService) applicationContext.getBean("goodServiceImpl");
        userService = (UserService) applicationContext.getBean("userServiceImpl");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute(USERNAME);

        req.setAttribute(CURRENT_USER_BUCKET, orderService.getUserGoods(username));
        req.setAttribute(MAKE_GOOD_LIST, goodService.getAllGoods());

        req.getRequestDispatcher(CONSUMER_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute(USERNAME);
        String id = req.getParameter(ID);

        Good good = goodService.getGoodById(Integer.parseInt(id));
        Order order = orderService.getOrderByUserId(userService.getUserByLogin(username).getId());

        orderService.addGoodInOrder(order, good);
        orderService.updateTotalPriceOfOrder(username);

        resp.sendRedirect(req.getContextPath() + CONSUMER);
    }
}