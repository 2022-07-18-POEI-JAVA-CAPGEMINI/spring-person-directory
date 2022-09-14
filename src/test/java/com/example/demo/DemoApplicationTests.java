package com.example.demo;

import com.example.demo.business.Person;
import com.example.demo.dao.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	PersonRepository personRepository;

	@Test
	void testFindAllByLastName() {
		List<Person> maFamille = personRepository.findAllByLastName("Dominguez");
		for (Person p : maFamille ) {
			System.out.println(p);
		}
	}

	@Test
	void testFindAllByFirstNameAndLastName(){
		List<Person> maFamille = personRepository.findAllByFirstNameAndLastName("JC","Dominguez");
		for (Person p : maFamille ) {
			System.out.println(p);
		}
	}

}
