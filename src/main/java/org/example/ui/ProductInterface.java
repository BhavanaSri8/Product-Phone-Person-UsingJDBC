package org.example.ui;

import org.example.dao.ProductDao;
import org.example.dao.ProductDaoImpl;
import org.example.entity.Product;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class ProductInterface {
    public static void main(String[] args) {
        ProductDao pdoa=new ProductDaoImpl();
        Scanner sc=new Scanner((System.in));

        while(true){
            System.out.println("\n================ PRODUCT MENU ================");
            System.out.println("1. Display All Products");
            System.out.println("2. Filter By Name");
            System.out.println("3. Filter By Rating");
            System.out.println("4. Filter By Category");
            System.out.println("5. Filter By Brand");
            System.out.println("6. Filter By Min Cost");
            System.out.println("7. Filter By Max Cost");
            System.out.println("8. Sort By Cost");
            System.out.println("9. Sort By Cost Descending");
            System.out.println("10. Sort By Discount");
            System.out.println("11. Sort By Discount Descending");
            System.out.println("12. Sort By Name");
            System.out.println("13. Sort By Name Descending");
            System.out.println("14. Add Product");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            int choice=sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1:
                    System.out.println("All products: ");
                    List<Product> li=pdoa.display();
                    li.forEach(System.out::println);
                    break;
                case 2:
                    System.out.println("\nFilter By Name: ");
                    System.out.println("Enter Product Name: ");
                    String str=sc.nextLine();
                    List<Product> na=pdoa.filterByName(str);
                    na.stream().forEach(System.out::println);
                    break;
                case 3:
                    System.out.println("\nFilter By Rating: ");
                    System.out.println("Enter Product Rating: ");
                    int r=sc.nextInt();
                    sc.nextLine();
                    List<Product> ra=pdoa.filterByRating(r);
                    ra.stream().forEach(System.out::println);
                    break;
                case 4:
                    System.out.println("\nFilter By Category: ");
                    System.out.println("Enter Category: ");
                    String s=sc.nextLine();
                    List<Product> category=pdoa.filterByCategory(s);
                    category.stream().forEach(System.out::println);
                    break;
                case 5:
                    System.out.println("\nFilter By Brand: ");
                    System.out.println("Enter Brand: ");
                    String s1=sc.nextLine();
                    List<Product> brand=pdoa.filterByBrand(s1);
                    brand.stream().forEach(System.out::println);
                    break;
                case 6:
                    System.out.println("Enter Min Cost: ");
                    int m1=sc.nextInt();
                    sc.nextLine();
                    List<Product> mini=pdoa.filterByMinCost(m1);
                    mini.stream().forEach(System.out::println);
                    break;
                case 7:
                    System.out.println("Enter Max Cost: ");
                    int m2=sc.nextInt();
                    sc.nextLine();
                    List<Product> maxi=pdoa.filterByMaxCost(m2);
                    maxi.stream().forEach(System.out::println);
                    break;
                case 8:
                    System.out.println("\nSorted By Cost: ");
                    List<Product> l1=pdoa.sortByCost();
                    l1.stream().forEach(System.out::println);
                    break;
                case 9:
                    System.out.println("\nSorted By Cost Descending: ");
                    List<Product> l2=pdoa.sortByCostDescending();
                    l2.stream().forEach(System.out::println);
                    break;
                case 10:
                    System.out.println("\nSorted By Discount: ");
                    List<Product> d1=pdoa.sortByDiscount();
                    d1.stream().forEach(System.out::println);
                    break;
                case 11:
                    System.out.println("\nSorted By Discount Descending: ");
                    List<Product> d2=pdoa.sortByDiscountDescending();
                    d2.stream().forEach(System.out::println);
                    break;
                case 12:
                    System.out.println("\nSorted By Name: ");
                    List<Product> n1=pdoa.sortByName();
                    n1.stream().forEach(System.out::println);
                    break;
                case 13:
                    System.out.println("\nSorted By Name Descending: ");
                    List<Product>  n2=pdoa.sortByNameDescending();
                    n2.stream().forEach(System.out::println);
                    break;
                case 14:

                    System.out.println("\nEnter Product Name: ");
                    String name=sc.nextLine();


                    System.out.println("\nEnter Cost: ");
                    Double cost=sc.nextDouble();

                    System.out.println("\nEnter Brand: ");
                    String br=sc.nextLine();


                    System.out.println("\nEnter Category: ");
                    String cate=sc.nextLine();


                    System.out.println("\nEnter Discount Percentage: ");
                    int dis=sc.nextInt();

                    System.out.println("\nEnter Rating: ");
                    int rate=sc.nextInt();
                    sc.nextLine();

                    pdoa.addProduct(new Product(name,cost,br,cate,dis,rate));
                    break;

                case 0:
                    System.out.println("Exiting.......");
                    System.exit(0);
                default:
                    System.out.println("\nInvalid Choice!!!!");
            }


        }

//        System.out.println("All products: ");
//        List<Product> li=pdoa.display();
//        li.forEach(System.out::println);
    }
}
