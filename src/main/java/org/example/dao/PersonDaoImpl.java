package org.example.dao;

import org.example.connection.DataBaseConnection;
import org.example.entity.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.BooleanSupplier;

public class PersonDaoImpl implements PersonDao{
    @Override
    public List<Person> findAll() {
        List<Person> plist=new ArrayList<>();
        String sql="SELECT * from Person";
        try(Connection con= DataBaseConnection.getConnection();){
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Person p=mapToPerson(rs);
                plist.add(p);
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return plist;
    }

    private Person mapToPerson(ResultSet rs) throws SQLException {
        int id=rs.getInt("id");
        String fname=rs.getString("Fname");
        String lname=rs.getString("Lname");
        return new Person(id,fname,lname);
    }

    @Override
    public void addPerson(Person p) {
        String sql="Insert into Person(fname,lname) Values(?,?)";
        try(Connection con=DataBaseConnection.getConnection();){
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,p.getFname());
            ps.setString(2,p.getLname());
            int rowsEffected=ps.executeUpdate();
            System.out.println("Rows Effected: "+rowsEffected);
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql="DELETE from Person where id=?";
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
    public Person findById(int id) {
        String sql="SELECT * FROM Person WHERE id=?";
        try(Connection con=DataBaseConnection.getConnection();){
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                return mapToPerson(rs);
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Person> findByNameContaining(String n) {
        List<Person> plist=new ArrayList<>();
        String sql="SELECT * FROM Person WHERE Fname LIKE ? OR Lname LIKE ?";
        try(Connection con=DataBaseConnection.getConnection();){
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,"%"+n+"%");
            ps.setString(2,"%"+n+"%");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                plist.add(mapToPerson(rs));
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return plist;
    }

    @Override
    public List<Person> findSortedByFname() {
        List<Person> plist=new ArrayList<>();
        String sql="SELECT * FROM Person ORDER BY Fname";
        try(Connection con=DataBaseConnection.getConnection();){
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                plist.add(mapToPerson(rs));
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return plist;
    }

//
//    public void menu() {
//        Scanner sc = new Scanner(System.in);
//
//        while (true) {
//            System.out.println("\n===== PERSON MENU =====");
//            System.out.println("1. Display All");
//            System.out.println("2. Add Person");
//            System.out.println("3. Delete By ID");
//            System.out.println("4. Find By ID");
//            System.out.println("5. Find By Name Containing");
//            System.out.println("6. Sort By Fname");
//            System.out.println("7. Exit");
//
//
//            System.out.print("Enter Choice: ");
//
//            int choice = sc.nextInt();
//            sc.nextLine();
//
//            switch (choice) {
//
//                case 1:
//                    List<Person> allPersons = findAll();
//                    allPersons.forEach(System.out::println);
//                    break;
//
//                case 2:
//                    System.out.print("Enter First Name: ");
//                    String fname = sc.nextLine();
//
//                    System.out.print("Enter Last Name: ");
//                    String lname = sc.nextLine();
//
//                    Person p = new Person(0, fname, lname);
//                    addPerson(p);
//                    break;
//
//                case 3:
//                    System.out.print("Enter ID to delete: ");
//                    int deleteId = sc.nextInt();
//                    deleteById(deleteId);
//                    break;
//
//                case 4:
//                    System.out.print("Enter ID to find: ");
//                    int findId = sc.nextInt();
//                    Person found = findById(findId);
//                    if (found != null) {
//                        System.out.println(found);
//                    } else {
//                        System.out.println("Person not found!");
//                    }
//                    break;
//
//                case 5:
//                    System.out.print("Enter name to search: ");
//                    String name = sc.nextLine();
//                    List<Person> searchList = findByNameContaining(name);
//                    searchList.forEach(System.out::println);
//                    break;
//
//                case 6:
//                    List<Person> sorted = findSortedByFname();
//                    sorted.forEach(System.out::println);
//                    break;
//
//                case 7:
//                    System.out.println("Exiting...");
//                    return;
//
//                default:
//                    System.out.println("Invalid Choice!");
//            }
//        }
//    }

}
