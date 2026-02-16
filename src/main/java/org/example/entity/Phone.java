package org.example.entity;

public class Phone {

    private int id;
    private String name;
    private String brand;
    private double cost;
    private int cameraPx;
    private String dateOfManufacture;

    public Phone() {

    }



    public Phone(String name, String brand, double cost, int cameraPx, String dateOfManufacture) {
        this.cameraPx = cameraPx;
        this.dateOfManufacture = dateOfManufacture;
        this.cost = cost;
        this.brand = brand;
        this.name = name;
    }



    public Phone(int id, String name, String brand, double cost, int cameraPx, String dateOfManufacture) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.cost = cost;
        this.cameraPx = cameraPx;
        this.dateOfManufacture = dateOfManufacture;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getBrand() { return brand; }
    public double getCost() { return cost; }
    public int getCameraPx() { return cameraPx; }
    public String getDateOfManufacture() { return dateOfManufacture; }

    @Override
    public String toString() {
        return "Phone{id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", cost=" + cost +
                ", cameraPx=" + cameraPx +
                ", dateOfManufacture='" + dateOfManufacture + '\'' +
                '}';
    }
}
