package org.example.ui;

import org.example.dao.PersonDao;
import org.example.dao.PersonDaoImpl;
import org.example.entity.Person;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {
        PersonDaoImpl dao = new PersonDaoImpl();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== PERSON MENU =====");
            System.out.println("1. Display All");
            System.out.println("2. Add Person");
            System.out.println("3. Delete By ID");
            System.out.println("4. Find By ID");
            System.out.println("5. Find By Name Containing");
            System.out.println("6. Sort By Fname");
            System.out.println("7. Exit");


            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    List<Person> allPersons = dao.findAll();
                    allPersons.forEach(System.out::println);
                    break;

                case 2:
                    System.out.print("Enter First Name: ");
                    String fname = sc.nextLine();

                    System.out.print("Enter Last Name: ");
                    String lname = sc.nextLine();

                    Person p = new Person(0, fname, lname);
                    dao.addPerson(p);
                    break;

                case 3:
                    System.out.print("Enter ID to delete: ");
                    int deleteId = sc.nextInt();
                    dao.deleteById(deleteId);
                    break;

                case 4:
                    System.out.print("Enter ID to find: ");
                    int findId = sc.nextInt();
                    Person found = dao.findById(findId);
                    if (found != null) {
                        System.out.println(found);
                    } else {
                        System.out.println("Person not found!");
                    }
                    break;

                case 5:
                    System.out.print("Enter name to search: ");
                    String name = sc.nextLine();
                    List<Person> searchList = dao.findByNameContaining(name);
                    searchList.forEach(System.out::println);
                    break;

                case 6:
                    List<Person> sorted = dao.findSortedByFname();
                    sorted.forEach(System.out::println);
                    break;

                case 7:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }

//        System.out.println("Enter Fname: ");
//        String fname=sc.nextLine();
//        System.out.println("Enter Lname: ");
//        String lname=sc.nextLine();
//        p.addPerson(new Person(fname,lname));

//        p.deleteById(3);

//        System.out.println("Person with id:\n "+ p.findById(6)+"\n");
//        System.out.println("\nEnter id: ");
//        int id=sc.nextInt();
//        System.out.println(p.findById(id));
//
//        System.out.println("\nEnter name: ");
//        String str=sc.next();
//        System.out.println(p.findByNameContaining(str));
//
//        System.out.println("\nSorted By First Name: ");
//        List<Person> per=p.findSortedByFname();
//        per.stream().forEach(System.out::println);
//
//        List<Person> person=p.findAll();
//        System.out.println("\nPerson Names:");
//        person.stream().forEach(System.out::println);



    }
}
