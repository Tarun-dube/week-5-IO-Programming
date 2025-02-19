package com.company.CSVdataHandling.Practice;
import java.io.*;

public class LargeCSVProcessor {
    public static void main(String[] args) {
        String filePath = "large_file.csv"; // Replace with actual file path
        int batchSize = 100;  // Number of lines to read in one go
        int totalRecords = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int batchCount = 0;

            // Read header line if present
            String header = br.readLine();
            System.out.println("Processing file with header: " + header);

            while ((line = br.readLine()) != null) {
                batchCount++;
                totalRecords++;

                // Process the line (Here we are just reading, but you can add your logic)
                // System.out.println(line);  // Uncomment to see the lines

                if (batchCount == batchSize) {
                    System.out.println("Processed " + totalRecords + " records so far...");
                    batchCount = 0;  // Reset batch count
                }
            }

            System.out.println("Total records processed: " + totalRecords);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

