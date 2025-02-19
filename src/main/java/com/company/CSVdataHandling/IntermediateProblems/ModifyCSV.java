package com.company.CSVdataHandling.IntermediateProblems;

import java.io.*;

public class ModifyCSV {
    public static void main(String[] args) {
        File input=new File("employee.csv");
        File output=new File("modified.csv");
        try(BufferedReader br=new BufferedReader(new FileReader(input))){
            String line;
            BufferedWriter bw=new BufferedWriter(new FileWriter(output));
            while((line=br.readLine())!=null){
                String [] columns = line.split(",");
                if(columns[3].equalsIgnoreCase("IT")){
                    double salary = Double.parseDouble(columns[2]);
                    salary+=salary/10;
                    columns[2] = String.valueOf(salary);
                    bw.write(columns[0]+","+columns[1]+","+columns[2]+","+columns[3]+"\n");
                }
                else{
                    bw.write(columns[0]+","+columns[1]+","+columns[2]+","+columns[3]+"\n");
                }

            }
            bw.flush();
            br.close();
            bw.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
