package com.company.CSVdataHandling.Practice;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.*;
import java.util.*;

public class JsonCsvConverter {

    // Convert JSON to CSV
    public static void jsonToCsv(String jsonFile, String csvFile) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<Map<String, Object>> students = objectMapper.readValue(new File(jsonFile), new TypeReference<>() {});

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))) {
                if (students.isEmpty()) {
                    System.out.println("No data to write.");
                    return;
                }

                // Write CSV Header
                Set<String> headers = students.get(0).keySet();
                writer.write(String.join(",", headers) + "\n");

                // Write Data Rows
                for (Map<String, Object> student : students) {
                    List<String> values = new ArrayList<>();
                    for (String header : headers) {
                        values.add(String.valueOf(student.get(header)));
                    }
                    writer.write(String.join(",", values) + "\n");
                }
                System.out.println("JSON successfully converted to CSV: " + csvFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Convert CSV back to JSON
    public static void csvToJson(String csvFile, String jsonFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(jsonFile))) {

            String headerLine = br.readLine();
            if (headerLine == null) {
                System.out.println("CSV file is empty.");
                return;
            }
            String[] headers = headerLine.split(",");

            List<Map<String, String>> studentList = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Map<String, String> student = new LinkedHashMap<>();
                for (int i = 0; i < headers.length; i++) {
                    student.put(headers[i], values[i]);
                }
                studentList.add(student);
            }

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(writer, studentList);
            System.out.println("CSV successfully converted to JSON: " + jsonFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String jsonFile = "students.json";
        String csvFile = "students.csv";
        String outputJsonFile = "converted_students.json";

        jsonToCsv(jsonFile, csvFile); // Convert JSON to CSV
        csvToJson(csvFile, outputJsonFile); // Convert CSV back to JSON
    }
}

