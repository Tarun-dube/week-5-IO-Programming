package com.company.Json.PracticeProblems;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONValidation {
    public static void main(String[] args) {
        String json = "{ \"name\": \"Alice\", \"age\": 25 }"; // Valid JSON
        // String json = "{ name: \"Alice\", age: 25 }"; // Invalid JSON (missing quotes)

        ObjectMapper mapper = new ObjectMapper();

        try {
            JsonNode node = mapper.readTree(json); // Parses JSON
            System.out.println("Valid JSON: " + node.toPrettyString());
        } catch (Exception e) {
            System.out.println("Invalid JSON: " + e.getMessage());
        }
    }
}
