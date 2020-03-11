package com.zadentech.springjdbc;

import java.util.Date;

import com.zadentech.springjdbc.entity.Person;
import com.zadentech.springjdbc.springdata.IPersonSpringDataRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	IPersonSpringDataRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("User id 10004-> {}", personRepository.findById(10004));
		logger.info("Inserting 10005 -> {}", personRepository.save(new Person("Yvonne", "Huntsville", new Date())));
		logger.info("Updating 10004 -> {}",  personRepository.save(new Person(10004, "Valentine", "Huntsville", new Date())));
		personRepository.deleteById(10002);
		logger.info("All users -> {}", personRepository.findAll());
		logger.info("All users in huntsville -> {}", personRepository.findAllByLocation("Huntsville"));
		// logger.info("User name Ranga -> {}", personRepository.findByName("Ranga"));
		// logger.info("User location NewYork-> {}", personRepository.findByLocation("New York"));
	}
}
