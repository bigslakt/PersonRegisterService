package com.example.demo;

import java.util.Map;

public interface Storage {

    Map create(Person person);

    Map readOne(String id);

    Map update(String id, String firstName);

    Map delete(String id);

    Map readAll();

}
