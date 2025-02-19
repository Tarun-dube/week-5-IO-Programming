package com.company.CSVdataHandling.BasicProblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadAndCount {
    public static void main(String[] args) {
        String file ="output.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                if(columns[0].matches("\\d+")) count++;
            }
            System.out.println("Total rows: "+count);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

