package com.company.CSVdataHandling.AdvanceProblem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ValidateCSV {
    public static void main(String[] args) {
        File input=new File("validity.csv");
        boolean valid=true;
        try(BufferedReader br=new BufferedReader(new FileReader(input))){
            String line;

            while((line=br.readLine())!=null){
                String[] columns=line.split(",");
                if(!columns[1].equalsIgnoreCase("Email") &&
                        !columns[1].matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")){
                    System.out.println("Invalid email address for: "+columns[0]);
                    valid=false;
                }
                if(!columns[2].equalsIgnoreCase("Number")
                && (!columns[2].matches("\\d+") || columns[2].length()!=10)){
                    System.out.println("Invalid number for: "+columns[0]);
                    valid=false;
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        if(valid)
        System.out.println("Valid Document");
    }
}
