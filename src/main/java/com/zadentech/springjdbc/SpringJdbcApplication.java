package com.zadentech.springjdbc;

import java.util.Date;

import com.zadentech.springjdbc.entity.Person;
import com.zadentech.springjdbc.jdbc.PersonJdbcRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class SpringJdbcApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJdbcRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All users -> {}", personRepository.findAll());
		logger.info("User id 10004-> {}", personRepository.findById(10004));
		logger.info("User name Ranga -> {}", personRepository.findByName("Ranga"));
		logger.info("User location NewYork-> {}", personRepository.findByLocation("New York"));
		logger.info("Deleting 10002 -> No of rows deleteed - {}", personRepository.deleteById(10002));
		logger.info("Inserting 10005 -> {}", (personRepository.insert(new Person(10005, "Yvonne", "Huntsville", new Date())))==1? "successful" : "unsuccessful");
		logger.info("Updating 10004 -> {}", (personRepository.update(new Person(10004, "Valentine", "Huntsville", new Date())))==1? "successful" : "unsuccessful");
	}
}
