package com.company.Json.PracticeProblems;

import org.json.JSONObject;

public class MergeJSON {
    public static void main(String[] args) {
        JSONObject obj1 = new JSONObject();
        obj1.put("name", "Alice");
        obj1.put("age", 25);

        JSONObject obj2 = new JSONObject();
        obj2.put("city", "New York");
        obj2.put("age", 30); // This will overwrite the previous "age"

        // Merge obj2 into obj1
        for (String key : obj2.keySet()) {
            obj1.put(key, obj2.get(key)); // Overwrites if key exists
        }

        System.out.println(obj1.toString(2)); // Pretty print with indentation
    }
}

