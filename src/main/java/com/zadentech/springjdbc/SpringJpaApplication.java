package com.zadentech.springjdbc;

import java.util.Date;

import com.zadentech.springjdbc.entity.Person;
import com.zadentech.springjdbc.jdbc.PersonJpaRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class SpringJpaApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJpaRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("User id 10004-> {}", personRepository.findById(10004));
		logger.info("Inserting 10005 -> {}", personRepository.insert(new Person("Yvonne", "Huntsville", new Date())));
		logger.info("Updating 10004 -> {}",  personRepository.update(new Person(10004, "Valentine", "Huntsville", new Date())));
		personRepository.deleteById(10002);
		logger.info("All users -> {}", personRepository.findAll());
		// logger.info("User name Ranga -> {}", personRepository.findByName("Ranga"));
		// logger.info("User location NewYork-> {}", personRepository.findByLocation("New York"));
	}
}
