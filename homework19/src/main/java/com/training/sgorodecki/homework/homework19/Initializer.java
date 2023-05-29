package com.training.sgorodecki.homework.homework19;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Initializer implements ServletContextListener {
    private  ClassPathXmlApplicationContext context;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        context.getBean("connector");
        sce.getServletContext().setAttribute("applicationContext", context);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    context.close();
    }
}