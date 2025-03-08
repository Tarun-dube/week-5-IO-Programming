package com.company.Json.PracticeProblems;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.ArrayList;

class Person {
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class ListToJson {
    public static void main(String[] args) throws Exception {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 25));
        people.add(new Person("Bob", 30));

        ObjectMapper mapper = new ObjectMapper();
        String jsonArray = mapper.writeValueAsString(people);

        System.out.println(jsonArray);
    }
}
