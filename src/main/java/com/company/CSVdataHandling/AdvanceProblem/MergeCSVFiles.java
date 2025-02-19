package com.company.CSVdataHandling.AdvanceProblem;

import java.io.*;
import java.util.*;

class Students {
    int id, age, marks;
    String name, grade;

    public Students(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public void addMarksAndGrade(int marks, String grade) {
        this.marks = marks;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + age + "," + marks + "," + grade;
    }
}

public class MergeCSVFiles {
    public static void main(String[] args) {
        String file1 = "student1.csv";
        String file2 = "student2.csv";
        String outputFile = "merged_students.csv";

        Map<Integer, Students> studentMap = new HashMap<>();

        // Read students1.csv
        try (BufferedReader br = new BufferedReader(new FileReader(file1))) {
            String line = br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                int age = Integer.parseInt(parts[2]);
                studentMap.put(id, new Students(id, name, age));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Read students2.csv and update studentMap
        try (BufferedReader br = new BufferedReader(new FileReader(file2))) {
            String line = br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                int marks = Integer.parseInt(parts[1]);
                String grade = parts[2];
                if (studentMap.containsKey(id)) {
                    studentMap.get(id).addMarksAndGrade(marks, grade);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Write merged data to merged_students.csv
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            bw.write("ID,Name,Age,Marks,Grade\n");
            for (Students student : studentMap.values()) {
                bw.write(student.toString() + "\n");
            }
            System.out.println("Merged file created: " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

