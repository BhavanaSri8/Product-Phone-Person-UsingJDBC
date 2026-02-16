package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/jdbc_db";
        String username="root";
        String password="Bhavana@2026";

        Connection con=null;
//
//        try{
//            con= DriverManager.getConnection(url,username,password);
//            String sql="CREATE TABLE Person(id Int PRIMARY KEY AUTO_INCREMENT,Fname varchar(50),Lname varchar(50))";
//            PreparedStatement ps=con.prepareStatement(sql);
//            ps.execute();
//            System.out.println("Table created Successfully");
//        }catch(SQLException e){
//            throw new RuntimeException(e);
//        }
        try{
            con= DriverManager.getConnection(url,username,password);
            String sql = "CREATE TABLE Product( id INT PRIMARY KEY AUTO_INCREMENT, pName VARCHAR(100) NOT NULL, cost DOUBLE NOT NULL, brand VARCHAR(100), category VARCHAR(100), discountPercentage INT, rating INT)";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.execute();
            System.out.println("Table created Successfully");
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}