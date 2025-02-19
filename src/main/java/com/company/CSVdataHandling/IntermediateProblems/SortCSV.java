package com.company.CSVdataHandling.IntermediateProblems;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SortCSV {

    public static void main(String[] args) {
        File input = new File("employee.csv");
        File output = new File("temp.csv");
        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(input))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String header=lines.get(0);
        lines.remove(0);
        lines.sort((row1, row2) -> (int) (Double.parseDouble(row2.split(",")[2]) - Double.parseDouble(row1.split(",")[2])));

        try (BufferedWriter bw = new BufferedWriter(new FileWriter((output)))) {
            bw.write(header);
            bw.newLine();
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(input.delete() && output.renameTo(input)) {
            System.out.println("sorted successfully");
        }

        System.out.println("top 5 highest paid employees");
        for(int i=0;i<5;i++){
            System.out.println(lines.get(i));
        }

    }
}
