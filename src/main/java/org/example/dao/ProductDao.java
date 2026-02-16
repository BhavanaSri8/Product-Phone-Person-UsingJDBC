package org.example.dao;

import org.example.entity.Product;
import java.util.List;

public interface ProductDao {

    void addProduct(Product product);

    List<Product> display();

    List<Product> filterByName(String name);

    List<Product> filterByBrand(String brand);

    List<Product> filterByCategory(String category);

    List<Product> filterByRating(int rating);

    List<Product> filterByMinCost(int cost);

    List<Product> filterByMaxCost(int cost);

    List<Product> sortByCost();

    List<Product> sortByCostDescending();

    List<Product> sortByName();

    List<Product> sortByNameDescending();

    List<Product> sortByDiscount();

    List<Product> sortByDiscountDescending();
}
