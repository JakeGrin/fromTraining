package com.training.sgorodecki.homework.homework21.util;

import com.training.sgorodecki.homework.homework21.exceptions.ConnectionException;
import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
@PropertySource("classpath:db.properties")
public class Connector {

    @Value("${dbUrl}")
    private String dbUrl;

    @Value("${user)")
    private String user;

    @Value("${pass}")
    private String pass;

    @Value("${dbCloseDelay}")
    private String dbCloseDelay;

    @Value("${initScript}")
    private String initScript;

    @Value("${tcp}")
    private String tcp;

    @Value("${tcpAllowOthers}")
    private String tcpAllowOthers;

    @Value("${tcpPort}")
    private String tcpPort;

    @Value("${port}")
    private String port;

    private Server server;

    public String getDbUrl() {
        return dbUrl;
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getDbCloseDelay() {
        return dbCloseDelay;
    }

    public void setDbCloseDelay(String dbCloseDelay) {
        this.dbCloseDelay = dbCloseDelay;
    }

    public String getInitScript() {
        return initScript;
    }

    public void setInitScript(String initScript) {
        this.initScript = initScript;
    }

    public String getTcp() {
        return tcp;
    }

    public void setTcp(String tcp) {
        this.tcp = tcp;
    }

    public String getTcpAllowOthers() {
        return tcpAllowOthers;
    }

    public void setTcpAllowOthers(String tcpAllowOthers) {
        this.tcpAllowOthers = tcpAllowOthers;
    }

    public String getTcpPort() {
        return tcpPort;
    }

    public void setTcpPort(String tcpPort) {
        this.tcpPort = tcpPort;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }


    @PostConstruct
    public void init() {
        try (Connection conn = DriverManager.getConnection(dbUrl + dbCloseDelay + initScript, user, pass)) {
            server = Server.createTcpServer(tcp, tcpAllowOthers, tcpPort, port);
        } catch (SQLException exception) {
            throw new ConnectionException("InitConnectionException");
        }
    }

    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dbUrl + dbCloseDelay, user, pass);
        } catch (SQLException exception) {
            throw new ConnectionException("ConnectionNotFoundException");
        }
        return conn;
    }

    @PreDestroy
    public void destroy() {
        server.stop();
    }
}