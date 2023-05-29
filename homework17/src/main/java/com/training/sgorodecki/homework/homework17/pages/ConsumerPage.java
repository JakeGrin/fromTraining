package com.training.sgorodecki.homework.homework17.pages;

import com.training.sgorodecki.homework.homework17.model.Product;
import com.training.sgorodecki.homework.homework17.services.BucketService;
import com.training.sgorodecki.homework.homework17.services.ShopService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/consumer", name = "Consumer")
public class ConsumerPage extends HttpServlet {

    private static final String USERNAME = "username";
    private static final String CURRENT_USER_BUCKET = "currentUserBucket";
    private static final String MAKE_GOOD_LIST = "makeGoodList";
    private static final String CONSUMER = "/consumer";
    private static final String ID = "id";
    private static final String CONSUMER_JSP = "WEB-INF/views/ConsumerPage.jsp";
    private final ShopService shopService = new ShopService();
    private final BucketService bucketService = BucketService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        req.setAttribute(CURRENT_USER_BUCKET, bucketService.makeUserBucket((String) session.getAttribute(USERNAME)));
        req.setAttribute(MAKE_GOOD_LIST, shopService.makeGoodsList());
        req.getRequestDispatcher(CONSUMER_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute(USERNAME);
        String id = req.getParameter(ID);
        Product product = shopService.getGoods().get(Integer.parseInt(id));
        bucketService.getMultimap().put(username, product);
        resp.sendRedirect(req.getContextPath() + CONSUMER);
    }
}