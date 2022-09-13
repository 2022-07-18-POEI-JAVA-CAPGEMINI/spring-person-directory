package com.example.demo.api;

import com.example.demo.business.Directory;
import com.example.demo.business.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminAnnuaireController {

    @Autowired
    Directory directory;

    @GetMapping("admin-persons")
    public List<Person> getAll(){
        return directory.getAll();
    }
}
