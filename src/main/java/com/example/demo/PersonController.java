package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class PersonController implements Storage{

    @Autowired
    PersonRepository personRepository;

    public PersonController() {
    }

    @RequestMapping(value = "/persons", method = POST)
    public Map<String, Object> create(@RequestBody Person person){

        return getStringObjectMap(person, "Person created successfully");
    }

    @RequestMapping(value = "/persons/id", method = GET)
    public Map<String, Object> readOne(@RequestParam String id) {

        Person person = personRepository.findOne(id);
        return getStringObjectMap(person, "Person found successfully");
    }

    @RequestMapping(value = "/persons", method = PUT)
    public Map<String, Object> update(@RequestParam String id, @RequestParam String firstName) {
        Person person = personRepository.findOne(id);
        person.setFirstName(firstName);
        return getStringObjectMap(person, "Person updated successfully");
    }

    @RequestMapping(value = "/persons", method = DELETE)
    public Map<String, Object> delete(@RequestParam String id) {

        personRepository.delete(id);
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("message", "Person deleted successfully");
        dataMap.put("status", "1");
        return dataMap;
    }

    @RequestMapping(value = "/persons", method = GET)
    public Map<String, Object> readAll() {
        List<Person> persons = personRepository.findAll();
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("message", "Persons found successfully");
        dataMap.put("nr of persons", persons.size());
        dataMap.put("status", "1");
        dataMap.put("persons", persons);
        return dataMap;
    }


    private Map<String, Object> getStringObjectMap(Person person, String s) {
        person = personRepository.save(person);
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("message", s);
        dataMap.put("status", "1");
        dataMap.put("person", person);
        return dataMap;
    }
}
