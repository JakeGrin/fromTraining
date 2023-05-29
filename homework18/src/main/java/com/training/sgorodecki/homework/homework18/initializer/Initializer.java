package com.training.sgorodecki.homework.homework18.initializer;

import com.training.sgorodecki.homework.homework18.exceptions.ConnectionException;
import com.training.sgorodecki.homework.homework18.util.Connector;
import org.h2.tools.Server;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.SQLException;

@WebListener
public class Initializer implements ServletContextListener {
    String tcp = "-tcp";
    String tcpAllowOthers = "-tcpAllowOthers";
    String tcpPort = "-tcpPort";
    String port = "9192";
    private Server server;

    private final Connector connector = Connector.getConnectorInstance();

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            Server.createTcpServer(tcp, tcpAllowOthers, tcpPort, port).start();
            connector.initConnection();
        } catch (SQLException exception) {
            throw new ConnectionException("ContextInitializedException");
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        server.stop();
    }
}