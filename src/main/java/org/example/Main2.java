package org.example;

import org.example.connection.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static java.time.chrono.JapaneseEra.values;

public class Main2 {
    public static void main(String[] args) {
//        String url="jdbc:mysql://localhost:3306/jdbc_db";
        Connection con= DataBaseConnection.getConnection();
        String sql="Insert into Person(Fname,Lname) Values(?,?)";
        try{
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,"Ramu");
            ps.setString(2,"Nayak");
            int rowsEffected=ps.executeUpdate();
            System.out.println("Rows Effected: "+rowsEffected);
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
