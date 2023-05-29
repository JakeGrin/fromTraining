package com.training.sgorodecki.homework.homework16.pages;

import com.training.sgorodecki.homework.homework16.model.Product;
import com.training.sgorodecki.homework.homework16.services.BucketService;
import com.training.sgorodecki.homework.homework16.services.ShopService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

@WebServlet(value = "/consumer", name = "Consumer")
public class ConsumerPage extends HttpServlet {

    private final ShopService shopService = new ShopService();
    private final BucketService bucketService = BucketService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();

        String consumerPage = "<html>" +
                "<body>" +
                "<div>" +
                "<p>" +
                "<br><br>" +
                "<h1 align=center><b> Hello " + session.getAttribute("username") + '!' + " </b><h1>" +
                checkUserBucket(session) +
                "<div align=center><ol>" + bucketService.makeUserBucket((String) session.getAttribute("username")) + "</ol></div>" +
                "<h2 align=center><form action=\"/consumer\" method=\"post\">" +
                "<select size=\"1\" name=\"id\" required = \"required\">" +
                shopService.makeGoodsList() +
                "</select>" +
                "</h2>" +
                "<p><h2 align=center><input type=\"submit\" value=\"Add item\"></form>" +
                "<br><br>" +
                "<form action=\"/order\" method=\"get\">" +
                "<input type=\"submit\" value=\"Submit\"></form></p></h2>" +
                "<br><br>" +
                "</div>" +
                "</body>" +
                "</html>";

        try (PrintWriter writer = resp.getWriter()) {
            writer.println(consumerPage);
        }
        resp.getWriter().println(consumerPage);
    }

    private String checkUserBucket(HttpSession session) {
        Collection<Product> products = bucketService.getMultimap().get((String) session.getAttribute("username"));
        String string = "<h2 align=center><b> Make your order </h2>";
        if (!products.isEmpty()) {
            string = "<h2 align=center><b> You have already chosen: </h2>";
        }
        return string;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        String id = req.getParameter("id");
        Product product = shopService.getGoods().get(Integer.parseInt(id));
        bucketService.getMultimap().put(username, product);
        resp.sendRedirect("/consumer");
    }
}