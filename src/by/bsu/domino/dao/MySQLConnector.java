package by.bsu.domino.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnector {
    private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final static String LOGIN = "root";
    private final static String PASSWORD = "vladvol";
    private final static String ADDRESS = "jdbc:mysql://localhost";
    private final static String DB_NAME = "domino";
    // asdf
    public static Connection getConnection() {
        Connection connection = null;

        //Connection without pool
        String url = ADDRESS + "/" + DB_NAME;

        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(url, LOGIN, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
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
