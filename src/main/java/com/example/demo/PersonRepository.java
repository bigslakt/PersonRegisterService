package com.example.demo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface PersonRepository extends MongoRepository<Person, String> {

}
