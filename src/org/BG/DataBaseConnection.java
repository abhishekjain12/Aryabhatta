package org.BG;

import java.sql.*;

public class DataBaseConnection {

    private static final String url = "jdbc:mysql://localhost:3306/brain-game";
    private static final String  uname = "root";
    private static final String password = "Future@4";
    private Connection connection = null;

    public Connection getDBConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url,uname,password);
        }
        catch (Exception e){
            System.out.println("" + e);
        }
        return connection;
    }
}
