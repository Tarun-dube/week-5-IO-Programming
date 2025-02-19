package com.company.CSVdataHandling.Practice;

import java.io.*;
import java.sql.*;

public class ExportEmployeeToCSV {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_database"; // Replace with your DB URL
        String user = "your_username"; // Replace with your DB username
        String password = "your_password"; // Replace with your DB password
        String csvFile = "employees.csv";

        String query = "SELECT id, name, department, salary FROM employees"; // Adjust table/column names as needed

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query);
             BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))) {

            // Write CSV header
            writer.write("Employee ID,Name,Department,Salary\n");

            // Write records
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String department = rs.getString("department");
                double salary = rs.getDouble("salary");

                writer.write(id + "," + name + "," + department + "," + salary + "\n");
            }

            System.out.println("Employee data successfully exported to " + csvFile);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}

