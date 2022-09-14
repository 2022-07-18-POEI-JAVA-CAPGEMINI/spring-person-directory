package com.example.demo.api;

import com.example.demo.business.Directory;
import com.example.demo.business.DirectoryDatabase;
import com.example.demo.business.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AnnuaireController {

    @Autowired
    DirectoryDatabase directory;

    @GetMapping("persons")
    public List<Person> getAll(){
        return directory.getAll();
    }

    @PostMapping("persons")
    public void postPerson(@RequestBody Person newPerson){
        directory.add(newPerson);
    }

    @DeleteMapping("persons/{id}")
    public void deletePerson(@PathVariable("id") Long id){
        directory.delete(id);
    }

    @PutMapping ("persons/{id}")
    public ResponseEntity<String> updatePerson(@RequestBody Person personToUpdate, @PathVariable("id") Long id){
        if(!id.equals(personToUpdate.getId())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("2 differents id values");
        } else {
            Optional<Person> optional = directory.findById(id);
            if(optional.isEmpty()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("id inexistant in database");
            } else {
                directory.update(id, personToUpdate);
                return ResponseEntity.status(HttpStatus.OK).body("OK updated");
            }
        }
    }
}
