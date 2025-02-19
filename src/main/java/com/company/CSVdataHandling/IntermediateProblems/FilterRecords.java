package com.company.CSVdataHandling.IntermediateProblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class FilterRecords {
    public static void main(String[] args) {
        try(BufferedReader br=new BufferedReader(new FileReader("students.csv"))){
            String line;
            while((line=br.readLine())!=null){
                String[] columns = line.split(",");

                if(columns[0].matches("\\d+") && Integer.parseInt(columns[3])>80){
                    System.out.println(columns[0]+", "+columns[1]+", "+columns[2]+", "+columns[3]);
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
