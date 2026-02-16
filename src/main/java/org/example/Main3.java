package org.example;

import org.example.connection.DataBaseConnection;

import javax.management.Query;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main3 {
    public static void main(String[] args) {
        try (Connection con = DataBaseConnection.getConnection()) {
            String updateSql = "UPDATE Person SET Fname='Hema' WHERE id=1";
            try (PreparedStatement ps = con.prepareStatement(updateSql)) {
                int rowsEffected=ps.executeUpdate();
                System.out.println("Rows Effected: "+rowsEffected);
            }

            String deleteSql = "DELETE FROM Person WHERE id=7";
            try (PreparedStatement ps = con.prepareStatement(deleteSql)) {
                int rowsEffect=ps.executeUpdate();
                System.out.println("Rows Effected: "+rowsEffect);
            }
            String orderBy = "SELECT * FROM Person ORDER BY fname";
            try (PreparedStatement ps = con.prepareStatement(orderBy);
                ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    System.out.println(rs.getInt("id") + " " + rs.getString("fname"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
