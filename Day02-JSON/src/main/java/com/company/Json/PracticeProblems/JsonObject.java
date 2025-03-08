package com.company.Json.PracticeProblems;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonObject {
    public static void main(String[] args) {
        JSONArray subject = new JSONArray();
        subject.put("maths");
        subject.put("english");
        subject.put("science");
        subject.put("physics");

        JSONObject student=new JSONObject();
        student.put("name","John");
        student.put("age",23);
        student.put("subject",subject);

        System.out.println(student.toString(4));

    }
}
