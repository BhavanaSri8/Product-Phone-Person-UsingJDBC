package org.example.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private static Connection connection;
    public static Connection getConnection(){
        String url="jdbc:mysql://localhost:3306/jdbc_db";
        String username="root";
        String password="Bhavana@2026";

        try{
            connection= DriverManager.getConnection(url,username,password);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return connection;
    }
    public void close(){

    }
}
