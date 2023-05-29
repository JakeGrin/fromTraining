package com.training.sgorodecki.homework.homework18.util;

import com.training.sgorodecki.homework.homework18.exceptions.ConnectionException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

    private static final String DB_URL = "jdbc:h2:mem:database";
    private static final String USER = "";
    private static final String PASS = "";
    private static final String DB_CLOSE_DELAY = ";DB_CLOSE_DELAY=-1";
    private static final String INIT_SCRIPT = ";INIT=RUNSCRIPT FROM 'classpath:init/init.sql'";

    private static Connector connectorInstance;

    private Connector(){

    }

    public static synchronized Connector getConnectorInstance() {
        if (connectorInstance == null) {
            connectorInstance = new Connector();
        }
        return connectorInstance;
    }

    public void initConnection() {
        try (Connection conn = DriverManager.getConnection(DB_URL + DB_CLOSE_DELAY + INIT_SCRIPT, USER, PASS)) {
        } catch (SQLException exception) {
            throw new ConnectionException("InitConnectionException");
        }
    }

    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL + DB_CLOSE_DELAY, USER, PASS);
        } catch (SQLException exception) {
          throw new ConnectionException("ConnectionNotFoundException");
        }
        return conn;
    }
}