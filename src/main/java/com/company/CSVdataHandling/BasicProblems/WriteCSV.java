package com.company.CSVdataHandling.BasicProblems;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteCSV {
    public static void main(String[] args) {


        try (BufferedWriter wr = new BufferedWriter(new FileWriter("employee.csv"))) {
            wr.write("ID,Name,Salary,Department\n");
            wr.write("1,John Smith,10000.00,Software Engineering\n");
            wr.write("2,Tarun Dubey,200000.00,Software Engineering\n");
            wr.write("3, Smith,10000.00,HR\n");
            wr.write("4,Emili,39203.00,Sales\n");
            wr.write("5,John william,25000.00,Cloud engineering\n");

    }catch (IOException e) {
            e.printStackTrace();
        }

    }
}

