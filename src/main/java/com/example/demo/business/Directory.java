package com.example.demo.business;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Directory {

    private List<Person> persons = new ArrayList<>();
    private long index = 0;

    public void add(Person person){
        index++;
        person.setId(index);
        persons.add(person);
    }

    public List<Person> getAll(){
        return persons;
    }

    public void delete(Long id){
        for(Person person : persons){
            if(person.getId().equals(id) ){
                persons.remove(person);
                break;
            }
        }
    }
    public void update(Long id, Person person){
        for(int i=0 ; i<persons.size(); i++){
            if(persons.get(i).getId().equals(id) ){
                persons.set(i, person);
                break;
            }
        }
    }
}
