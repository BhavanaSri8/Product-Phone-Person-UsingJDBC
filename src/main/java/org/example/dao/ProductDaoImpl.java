package org.example.dao;

import org.example.connection.DataBaseConnection;
import org.example.entity.Person;
import org.example.entity.Product;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao{
    @Override
    public void addProduct(Product product) {
        String sql="Insert into Product(pName, cost, brand, category, discountPercentage, rating) Values(?,?,?,?,?,?)";
        try(Connection con= DataBaseConnection.getConnection();){
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,product.getpName());
            ps.setDouble(2,product.getCost());
            ps.setString(3,product.getBrand());
            ps.setString(4,product.getCategory());
            ps.setInt(5,product.getPercentage());
            ps.setInt(6,product.getRating());

            int rowsEffected=ps.executeUpdate();
            System.out.println("Rows Effected: "+rowsEffected);
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> display() {
        List<Product> pList=new ArrayList<>();
        String sql="SELECT * from Product";
        try(Connection con=DataBaseConnection.getConnection();){
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()) {
                Product p=mapToProduct(rs);
                pList.add(p);
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return pList;
    }

    private Product mapToProduct(ResultSet rs) throws SQLException {
        int id=rs.getInt("Id");
        String name=rs.getString("pName");
        double cost=rs.getDouble("cost");
        String brand=rs.getString("brand");
        String category=rs.getString("category");
        int rating=rs.getInt("rating");
        int discount=rs.getInt("discountPercentage");
        return new Product(id,name,cost,brand,category,rating,discount);
    }

    @Override
    public List<Product> filterByName(String name) {
        List<Product> plist=new ArrayList<>();
        String sql="Select * from Product where pName=?";
        try(Connection con= DataBaseConnection.getConnection();){
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,name);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Product p =mapToProduct(rs);
                plist.add(p);
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return plist;
    }

    @Override
    public List<Product> filterByBrand(String brand) {
        List<Product> plist=new ArrayList<>();
        String sql="Select * from Product where brand=?";
        try(Connection con= DataBaseConnection.getConnection();){
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,brand);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Product p =mapToProduct(rs);
                plist.add(p);
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return plist;
    }

    @Override
    public List<Product> filterByCategory(String category) {
        List<Product> plist=new ArrayList<>();
        String sql="Select * from Product where category=?";
        try(Connection con= DataBaseConnection.getConnection();){
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,category);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Product p =mapToProduct(rs);
                plist.add(p);
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return plist;
    }

    @Override
    public List<Product> filterByRating(int rating) {
        List<Product> plist=new ArrayList<>();
        String sql="Select * from Product where rating=?";
        try(Connection con= DataBaseConnection.getConnection();){
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,rating);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Product p =mapToProduct(rs);
                plist.add(p);
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return plist;
    }

    @Override
    public List<Product> filterByMinCost(int cost) {
        List<Product> plist=new ArrayList<>();
        String sql="Select * from Product where cost>=?";
        try(Connection con= DataBaseConnection.getConnection();){
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,cost);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Product p =mapToProduct(rs);
                plist.add(p);
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return plist;
    }

    @Override
    public List<Product> filterByMaxCost(int cost) {
        List<Product> plist=new ArrayList<>();
        String sql="Select * from Product where cost<=?";
        try(Connection con= DataBaseConnection.getConnection();){
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,cost);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
//                Product p =mapToProduct(rs);
                plist.add(mapToProduct(rs));
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return plist;
    }

    @Override
    public List<Product> sortByCost() {
        List<Product> plist=new ArrayList<>();
        String sql="SELECT * FROM Product ORDER BY cost";
        try(Connection con=DataBaseConnection.getConnection();){
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                plist.add(mapToProduct(rs));
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return plist;
    }

    @Override
    public List<Product> sortByCostDescending() {
        List<Product> plist=new ArrayList<>();
        String sql="SELECT * FROM Product ORDER BY cost desc";
        try(Connection con=DataBaseConnection.getConnection();){
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                plist.add(mapToProduct(rs));
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return plist;
    }

    @Override
    public List<Product> sortByName() {
        List<Product> plist=new ArrayList<>();
        String sql="SELECT * FROM Product ORDER BY pName";
        try(Connection con=DataBaseConnection.getConnection();){
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                plist.add(mapToProduct(rs));
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return plist;
    }

    @Override
    public List<Product> sortByNameDescending() {
        List<Product> plist=new ArrayList<>();
        String sql="SELECT * FROM Product ORDER BY pName desc";
        try(Connection con=DataBaseConnection.getConnection();){
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                plist.add(mapToProduct(rs));
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return plist;
    }

    @Override
    public List<Product> sortByDiscount() {
        List<Product> plist=new ArrayList<>();
        String sql="SELECT * FROM Product ORDER BY discountPercentage";
        try(Connection con=DataBaseConnection.getConnection();){
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                plist.add(mapToProduct(rs));
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return plist;
    }

    @Override
    public List<Product> sortByDiscountDescending() {
        List<Product> plist=new ArrayList<>();
        String sql="SELECT * FROM Product ORDER BY discountPercentage desc";
        try(Connection con=DataBaseConnection.getConnection();){
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                plist.add(mapToProduct(rs));
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return plist;
    }
}
