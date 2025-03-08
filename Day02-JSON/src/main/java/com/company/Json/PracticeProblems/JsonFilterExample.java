package com.company.Json.PracticeProblems;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;
import java.util.stream.Collectors;

class Persons {
    public String name;
    public int age;

    public Persons() {}  // Default constructor (required by Jackson)

    public Persons(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class JsonFilterExample {
    public static void main(String[] args) throws Exception {
        String jsonArray = "[{\"name\": \"Alice\", \"age\": 25}, {\"name\": \"Bob\", \"age\": 30}, {\"name\": \"Charlie\", \"age\": 35}]";

        ObjectMapper mapper = new ObjectMapper();

        // Parse JSON array into List<Persons>
        List<Persons> people = mapper.readValue(jsonArray, new TypeReference<List<Persons>>() {});

        // Filter people with age > 25
        List<Persons> filteredList = people.stream()
                .filter(person -> person.age > 25)
                .collect(Collectors.toList());

        // Convert filtered list back to JSON
        String filteredJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(filteredList);

        System.out.println(filteredJson);
    }
}
