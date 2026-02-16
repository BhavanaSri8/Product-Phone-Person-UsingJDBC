package org.example.entity;

public class Person {
    private int id;

    public String getFname() {
        return fname;
    }

    public int getId() {
        return id;
    }

    public String getLname() {
        return lname;
    }

    private String fname;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                '}';
    }

    private String lname;

    public Person(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }

    public Person() {

    }


    public Person(int id, String fname, String lname) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
    }



}
