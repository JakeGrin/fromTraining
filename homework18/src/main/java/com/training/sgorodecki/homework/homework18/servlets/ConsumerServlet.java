package com.training.sgorodecki.homework.homework18.servlets;

import com.training.sgorodecki.homework.homework18.entity.Good;
import com.training.sgorodecki.homework.homework18.entity.Order;
import com.training.sgorodecki.homework.homework18.services.api.GoodService;
import com.training.sgorodecki.homework.homework18.services.api.OrderService;
import com.training.sgorodecki.homework.homework18.services.api.UserService;
import com.training.sgorodecki.homework.homework18.services.impl.GoodServiceImpl;
import com.training.sgorodecki.homework.homework18.services.impl.OrderServiceImpl;
import com.training.sgorodecki.homework.homework18.services.impl.UserServiceImpl;

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
        orderService = OrderServiceImpl.getInstance();
        goodService = GoodServiceImpl.getInstance();
        userService = UserServiceImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute(USERNAME);

        req.setAttribute(CURRENT_USER_BUCKET, orderService.getGoods(username));
        req.setAttribute(MAKE_GOOD_LIST, goodService.getAll());

        req.getRequestDispatcher(CONSUMER_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute(USERNAME);
        String id = req.getParameter(ID);

        Good good = goodService.getById(Integer.parseInt(id));
        Order order = orderService.getByUserId(userService.getByLogin(username).getId());

        orderService.addGood(order, good);
        orderService.updateTotalPriceOfOrder(username);

        resp.sendRedirect(req.getContextPath() + CONSUMER);
    }
}