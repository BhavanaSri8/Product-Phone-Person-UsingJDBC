package org.example.dao;

import org.example.entity.Person;

import java.util.List;

public interface PersonDao {
    List<Person> findAll();
    void addPerson(Person p);
    void deleteById(int id);
    Person findById(int id);
    List<Person> findByNameContaining(String n);
    List<Person> findSortedByFname();
}
