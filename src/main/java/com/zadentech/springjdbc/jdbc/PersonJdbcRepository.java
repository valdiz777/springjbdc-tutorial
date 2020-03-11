package com.zadentech.springjdbc.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.zadentech.springjdbc.entity.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * PersonRepository
 */
@Repository
public class PersonJdbcRepository {

    //connect to the database
    @Autowired
    JdbcTemplate jdbcTemplate;

    // leave as internal class to tie scope to repository
    class PersonRowMapper implements RowMapper<Person> {

        @Override
        public Person mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Person person = new Person();
            person.setId(resultSet.getInt("id"));
            person.setName(resultSet.getString("name"));
            person.setLocation(resultSet.getString("location"));
            person.setBirthDate(resultSet.getTimestamp("birth_date"));
            return person;
        }
    }

    public List<Person> findAll() {

        return jdbcTemplate.query("select * from person", new PersonRowMapper());

    }

    public Person findById(int id) {

        return (Person) jdbcTemplate.queryForObject("select * from person where id=?", new Object[] { id },
                new BeanPropertyRowMapper(Person.class));

    }

    public Object findByName(String name) {
        return (Person) jdbcTemplate.queryForObject("select * from person where name=?", new Object[] { name },
                new BeanPropertyRowMapper(Person.class));

    }

    public Object findByLocation(String location) {
        return (Person) jdbcTemplate.queryForObject("select * from person where location=?", new Object[] { location },
                new BeanPropertyRowMapper(Person.class));
    }

    // returns how many rows where deleted
    public int deleteById(int id) {

        return jdbcTemplate.update("delete from person where id=?", new Object[] { id });

    }

    public int deleteByName(String name) {
        return jdbcTemplate.update("delete from person where name=?", new Object[] { name });

    }

    public int deleteByLocation(String location) {
        return jdbcTemplate.update("delete from person where location=?", new Object[] { location });
    }

    public int insert(Person person) {
        return jdbcTemplate.update("insert into person (id, name, location, birth_date ) values(?, ?, ?, ?)",
                new Object[] { person.getId(), person.getName(), person.getLocation(),
                        new Timestamp(person.getBirthDate().getTime()) });
    }

    public int update(Person person) {
        return jdbcTemplate.update("update person set name = ?, location = ?, birth_date = ? where id=?",
                new Object[] { person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime()),
                        person.getId() });
    }
}