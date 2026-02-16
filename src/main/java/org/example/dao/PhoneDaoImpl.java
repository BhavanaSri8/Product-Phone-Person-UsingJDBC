package org.example.dao;

import org.example.connection.DataBaseConnection;
import org.example.entity.Person;
import org.example.entity.Phone;
import org.example.entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhoneDaoImpl implements PhoneDao{
    @Override
    public void addPhone(Phone phone) {
        String sql="Insert into Phone(name,brand,cost,cameraPx,dateOfManufacture) Values(?,?,?,?,?)";
        try(Connection con= DataBaseConnection.getConnection();){
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,phone.getName());
            ps.setString(2,phone.getBrand());
            ps.setDouble(3,phone.getCost());
            ps.setInt(4,phone.getCameraPx());
            ps.setString(5,phone.getDateOfManufacture());

            int rowsEffected=ps.executeUpdate();
            System.out.println("Rows Effected: "+rowsEffected);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql="DELETE from Phone where id=?";
        try(Connection con=DataBaseConnection.getConnection();){
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,id);
            int rowsEffected=ps.executeUpdate();
            System.out.println("Rows Effected: "+rowsEffected);
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Phone> findAll() {
        List<Phone> plist=new ArrayList<>();
        String sql="SELECT * from Phone";
        try(Connection con= DataBaseConnection.getConnection();){
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                plist.add(mapToPhone(rs));
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return plist;
    }

    private Phone mapToPhone(ResultSet rs) throws SQLException {
        int id=rs.getInt("id");
        String name=rs.getString("name");
        String brand=rs.getString("brand");
        Double cost=rs.getDouble("cost");
        int camerapx=rs.getInt("cameraPx");
        String date=rs.getString("dateOfManufacture");
        return new Phone(id,name,brand,cost,camerapx,date);
    }

    @Override
    public List<Phone> filterByBrand(String brand) {
        List<Phone> plist=new ArrayList<>();
        String sql="Select * from Phone where brand=?";
        try(Connection con= DataBaseConnection.getConnection();){
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,brand);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Phone p =mapToPhone(rs);
                plist.add(p);
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return plist;
    }

    @Override
    public List<Phone> sortByName() {
        List<Phone> plist=new ArrayList<>();
        String sql="SELECT * FROM Phone ORDER BY name";
        try(Connection con=DataBaseConnection.getConnection();){
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                plist.add(mapToPhone(rs));
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return plist;
    }

    @Override
    public List<Phone> sortByNameDescending() {
        List<Phone> plist=new ArrayList<>();
        String sql="SELECT * FROM Phone ORDER BY name desc";
        try(Connection con=DataBaseConnection.getConnection();){
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                plist.add(mapToPhone(rs));
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return plist;
    }

    @Override
    public List<Phone> sortByCost() {
        List<Phone> plist=new ArrayList<>();
        String sql="SELECT * FROM Phone ORDER BY cost";
        try(Connection con=DataBaseConnection.getConnection();){
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                plist.add(mapToPhone(rs));
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return plist;
    }

    @Override
    public List<Phone> sortByCostDescending() {
        List<Phone> plist=new ArrayList<>();
        String sql="SELECT * FROM Phone ORDER BY cost desc";
        try(Connection con=DataBaseConnection.getConnection();){
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                plist.add(mapToPhone(rs));
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return plist;
    }

    @Override
    public List<Phone> sortByDate() {
        List<Phone> plist=new ArrayList<>();
        String sql="SELECT * FROM Phone ORDER BY dateofManufacture";
        try(Connection con=DataBaseConnection.getConnection();){
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                plist.add(mapToPhone(rs));
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return plist;
    }

    @Override
    public List<Phone> sortByDateDescending() {
        List<Phone> plist=new ArrayList<>();
        String sql="SELECT * FROM Phone ORDER BY dateofManufacture desc";
        try(Connection con=DataBaseConnection.getConnection();){
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                plist.add(mapToPhone(rs));
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return plist;
    }
}
