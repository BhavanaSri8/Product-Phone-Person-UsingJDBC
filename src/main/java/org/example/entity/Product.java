package org.example.entity;

public class Product {
    private int id;
    private String pName;
    private double cost;
    private String brand;
    private String category;
    private int discountPercentage;
    private int rating;

    public Product() {

    }


    public Product(String pName, double cost, String brand, String category, int rating, int discountPercentage) {
        this.pName = pName;
        this.cost = cost;
        this.brand = brand;
        this.category = category;
        this.rating = rating;
        this.discountPercentage = discountPercentage;
    }



    public Product(int id, String pName, double cost, String brand, String category, int rating, int discountPercentage){
        this.id=id;
        this.pName=pName;
        this.cost=cost;
        this.brand=brand;
        this.category=category;
        this.rating=rating;
        this.discountPercentage=discountPercentage;

    }

    public int getId() {
        return id;
    }

    public String getpName() {
        return pName;
    }

    public double getCost() {
        return cost;
    }

    public String getBrand() {
        return brand;
    }

    public String getCategory() {
        return category;
    }

    public int getRating() {
        return rating;
    }

    public int getPercentage() {
        return discountPercentage;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", pName='" + pName + '\'' +
                ", cost=" + cost +
                ", brand='" + brand + '\'' +
                ", category='" + category + '\'' +
                ", rating=" + rating +
                ", percentage=" + discountPercentage +
                '}';
    }

}