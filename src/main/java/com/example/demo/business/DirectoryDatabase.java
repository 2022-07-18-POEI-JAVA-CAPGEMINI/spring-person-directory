package com.example.demo.business;

import com.example.demo.dao.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DirectoryDatabase {

    @Autowired
    PersonRepository personRepository;

    public void add(Person person){
        System.out.println(person.getId());
        personRepository.save(person);
        System.out.println(person.getId());
    }

    public List<Person> getAll(){
            return personRepository.findAll();
    }

    public Optional<Person> findById(Long id){
        Optional<Person> optional = personRepository.findById(id);
        return optional;
    }

    public void delete(Long id){
            personRepository.deleteById(id);
    }
    public void update(Long id, Person person){
        personRepository.save(person);
        System.out.println(person.getId());
    }
}