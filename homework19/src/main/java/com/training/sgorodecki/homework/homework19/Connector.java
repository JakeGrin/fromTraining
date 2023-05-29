package com.training.sgorodecki.homework.homework19;

import org.h2.tools.Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

    private String dbUrl;
    private String jdbcDriver;
    private String user;
    private String pass ;
    private String dbCloseDelay ;
    private String initScript;

    private String tcp;
    private String tcpAllowOthers;
    private String tcpPort;
    private String port;
    private Server server;

    public String getDbUrl() {
        return dbUrl;
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    public String getJdbcDriver() {
        return jdbcDriver;
    }

    public void setJdbcDriver(String jdbcDriver) {
        this.jdbcDriver = jdbcDriver;
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

    public void init(){
        try (Connection conn = DriverManager.getConnection(dbUrl + dbCloseDelay + initScript, user, pass)) {
            Class.forName(jdbcDriver);
            server = Server.createTcpServer(tcp,tcpAllowOthers,tcpPort,port);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dbUrl + dbCloseDelay, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public void destroy(){
        server.stop();
    }

}