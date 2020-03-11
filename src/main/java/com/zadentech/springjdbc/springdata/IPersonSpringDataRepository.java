package com.zadentech.springjdbc.springdata;

import java.util.List;

import com.zadentech.springjdbc.entity.Person;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * PersonSpringDataRepository
 */
public interface IPersonSpringDataRepository extends JpaRepository<Person, Integer> {

    public List<Person> findAllByLocation(String location);

}