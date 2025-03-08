package com.company.Json.PracticeProblems;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;

import java.io.File;
import java.util.List;

class Student{
    public  String name;
    public  int age;
    public String email;
    public List<String> subjects;

}
public class ReadJsonFile {
    public static void main(String[] args) {
        try{
            ObjectMapper mapper = new ObjectMapper();
            Student student = mapper.readValue(new File("student.json"),Student.class);
            System.out.println("Name: " + student.name);
            System.out.println("Email: " + student.email);
            System.out.println("Subjects: " + student.subjects);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
