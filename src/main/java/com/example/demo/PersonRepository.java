package com.example.demo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
public interface PersonRepository extends MongoRepository<Person, String> {

    /*Optional<Person> findById(String id);

    Person findByFirstName(String firstName);

    Person findByLastName(String lastName);

    Person findByAge(int id);

    Person findOne(String id);

    void delete(String bookingId);*/
}
