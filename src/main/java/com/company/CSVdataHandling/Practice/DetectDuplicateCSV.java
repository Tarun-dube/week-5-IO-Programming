package com.company.CSVdataHandling.Practice;

import java.io.*;
import java.util.*;

public class DetectDuplicateCSV {
    public static void main(String[] args) {
        String filePath = "students.csv"; // Replace with actual file path
        Set<String> uniqueIds = new HashSet<>();
        List<String> duplicateRecords = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) { // Skip the header row
                    isHeader = false;
                    continue;
                }

                String[] parts = line.split(",");
                if (parts.length > 0) {
                    String id = parts[0].trim();

                    if (!uniqueIds.add(id)) { // If ID is already in set, it's a duplicate
                        duplicateRecords.add(line);
                    }
                }
            }

            // Print duplicate records
            if (!duplicateRecords.isEmpty()) {
                System.out.println("Duplicate Records Found:");
                for (String record : duplicateRecords) {
                    System.out.println(record);
                }
            } else {
                System.out.println("No duplicate records found.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

