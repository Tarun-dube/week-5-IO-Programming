package com.company.CSVdataHandling.AdvanceProblem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Student {
    int id;
    String name;
    int age;
    int marks;

    Student(int id, String name, int age, int marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    public String toString() {
        return id + " " + name + " " + age + " " + marks;
    }
}
public class ConvertIntoObjects {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<Student>();
        try(BufferedReader br = new BufferedReader(new FileReader("students.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if(data[0].matches("\\d+")) {
                    students.add(new Student(Integer.parseInt(data[0]), data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3])));
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        for(Student student : students) {
            System.out.println(student);
        }

    }
}
