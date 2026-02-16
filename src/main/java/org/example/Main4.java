package org.example;

import org.example.connection.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main4 {
    public static void main(String[] args) {
        try (Connection con = DataBaseConnection.getConnection();) {
            String sql = "SELECT * FROM Person";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String fname = rs.getString("Fname");
                String lname = rs.getString("Lname");
                System.out.println("Id: " + id + ", Name: " + fname + " " + lname);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
