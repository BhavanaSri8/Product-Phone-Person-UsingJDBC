package org.example.dao;


import org.example.entity.Phone;

import java.util.List;

public interface PhoneDao {

    void addPhone(Phone phone);

    void deleteById(int id);

    List<Phone> findAll();

    List<Phone> filterByBrand(String brand);

    List<Phone> sortByName();

    List<Phone> sortByNameDescending();

    List<Phone> sortByCost();

    List<Phone> sortByCostDescending();

    List<Phone> sortByDate();

    List<Phone> sortByDateDescending();
}
