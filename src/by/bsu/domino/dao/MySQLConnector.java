package by.bsu.domino.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnector {
    private final static String LOGIN = "root";
    private final static String PASSWORD = "PaVeL01111999";
    private final static String ADDRESS = "jdbc:mysql://localhost";
    private final static String DB_NAME = "dominoproject";
    private final static String DEFAULT_TIMEZONE = "Europe/Moscow";

    public static Connection getConnection() {
        Connection connection = null;

        //Connection without pool
        String url = ADDRESS + "/" + DB_NAME + "?serverTimezone=" + DEFAULT_TIMEZONE + "&useSSL=false";
        try {
            connection = DriverManager.getConnection(url, LOGIN, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        /*
        try{
            Context envCtx = (Context) (new InitialContext().lookup("java:comp/env"));
            DataSource ds = (DataSource) envCtx.lookup("jdbc/dominoproject");
            connection = ds.getConnection();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        */
        return connection;
    }
}
