package com.company.CSVdataHandling.IntermediateProblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class SearchRecord {
    public static void searchRecord(String name) {
        try(BufferedReader br= new BufferedReader(new FileReader("employee.csv"))){
            String line;
            boolean found = false;
            while((line=br.readLine())!=null){
                String[] colums = line.split(",");
                // search employee name tarun
                if(colums[1].equals(name)){
                    System.out.println("Department: " + colums[3]+" Salary: " + colums[2]);
                    found = true;
                }
            }
            if(!found){
                System.out.println("No record found");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        String searchName = "Tarun Dubey";
        searchRecord(searchName);
        searchRecord("Emili");
        searchRecord("John Smith");
        searchRecord("John");
    }
}
