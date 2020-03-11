package com.zadentech.springjdbc.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * Person
 */
@Entity //hook in for entity manager (for JPA). you don't need this for JDBC ...
// @Table(name="person") <- an alternative way of doing this if we did not have
// the name match of Person to the table "person"
@NamedQuery(name="find_all_persons", query="select p from Person p")
public class Person {

    @Id // highlights the Id/primary key in the table
    @GeneratedValue // Hibernate uses this to auto generate the primary key on inserts
    private int id;
    // @Column(name="name") <- an alternative way of doing this if we did not have
    // the name match of name to the column "name"
    private String name;
    private String location;
    private Date birthDate;

    public Person() {

    }

    // Constructor for hibernate, since it automatically generates the Id
    public Person(String name, String location, Date birthDate) {
        this.name = name;
        this.location = location;
        this.birthDate = birthDate;
    }


    public Person(int id, String name, String location, Date birthDate) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "\nPerson [birthDate=" + birthDate + ", id=" + id + ", location=" + location + ", name=" + name + "]";
    }
}