package com.company.CSVdataHandling.BasicProblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadAndPrint {
    public static void main(String[] args) {
        String file ="students.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                for (String column : columns) {
                    System.out.print(column+" ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
