package org.example.ui;

import org.example.dao.PhoneDao;
import org.example.dao.PhoneDaoImpl;
import org.example.entity.Phone;

import java.util.List;
import java.util.Scanner;

public class PhoneInterface {
    public static void main(String[] args) {
        PhoneDao pa=new PhoneDaoImpl();
        Scanner sc=new Scanner(System.in);

        while(true){
            System.out.println("\n========= PHONE MENU =========");
            System.out.println("1. Display All Phones");
            System.out.println("2. Add Phone");
            System.out.println("3. Delete By ID");
            System.out.println("4. Filter By Brand");
            System.out.println("5. Sort By Name");
            System.out.println("6. Sort By Name Descending");
            System.out.println("7. Sort By Cost");
            System.out.println("8. Sort By Cost Descending");
            System.out.println("9. Sort By Date");
            System.out.println("10. Sort By Date Descending");
            System.out.println("0. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1:
                    pa.findAll().forEach(System.out::println);
                    break;
                case 2:
                    System.out.println("\nEnter Name: ");
                    String name=sc.next();

                    System.out.println("\nEnter Brand: ");
                    String br1=sc.next();

                    System.out.println("\nEnter cost: ");
                    double cost1=sc.nextDouble();

                    System.out.println("\nEnter camera Pixel: ");
                    int pixel=sc.nextInt();

                    System.out.println("\nEnter Date of Manufacture: ");
                    String date=sc.next();

                    pa.addPhone(new Phone(name,br1,cost1,pixel,date));
                    break;
                case 3:
                    System.out.println("\nEnter ID: ");
                    int id=sc.nextInt();
                    pa.deleteById(id);
                    break;
                case 4:
                    System.out.println("\nEnter Brand: ");
                    String brand=sc.next();
                    List<Phone> p=pa.filterByBrand(brand);
                    p.stream().forEach(System.out::println);
                    break;
                case 5:
                    System.out.println("\nSort By Name: ");
                    List<Phone> p1=pa.sortByName();
                    p1.stream().forEach(System.out::println);
                    break;
                case 6:
                    System.out.println("\nSort By Name Descending: ");
                    List<Phone> p2=pa.sortByNameDescending();
                    p2.stream().forEach(System.out::println);
                    break;
                case 7:
                    System.out.println("\nSort By Cost: ");
                    List<Phone> c1=pa.sortByCost();
                    c1.stream().forEach(System.out::println);
                    break;
                case 8:
                    System.out.println("\nSort By Cost Descending: ");
                    List<Phone> c2=pa.sortByCostDescending();
                    c2.stream().forEach(System.out::println);
                    break;
                case 9:
                    System.out.println("\nSort By Date: ");
                    List<Phone> d1=pa.sortByDate();
                    d1.stream().forEach(System.out::println);
                    break;
                case 10:
                    System.out.println("\nSort By Date Descending: ");
                    List<Phone> d2=pa.sortByDateDescending();
                    d2.stream().forEach(System.out::println);
                    break;
                case 0:
                    System.out.println("exiting.......");
                    System.exit(0);
                default:
                    System.out.println("\nInvalid Choice..");
            }
        }
    }
}
