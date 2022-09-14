package com.example.demo.dao;

import com.example.demo.business.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

        List<Person> findAllByLastName(String lastName);
        List<Person> findAllByFirstNameAndLastName(String firstName, String lastName);

}