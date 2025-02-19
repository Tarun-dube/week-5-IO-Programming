package com.company.CSVdataHandling.Practice;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.util.Base64;

public class CsvEncryption {
    private static final String SECRET_KEY = "1234567890123456"; // 16-char key for AES

    // AES Encryption
    public static String encrypt(String value) {
        try {
            SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            return Base64.getEncoder().encodeToString(cipher.doFinal(value.getBytes()));
        } catch (Exception e) {
            throw new RuntimeException("Encryption error", e);
        }
    }

    // AES Decryption
    public static String decrypt(String value) {
        try {
            SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            return new String(cipher.doFinal(Base64.getDecoder().decode(value)));
        } catch (Exception e) {
            throw new RuntimeException("Decryption error", e);
        }
    }

    // Write encrypted CSV
    public static void writeEncryptedCSV(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("ID,Name,Email,Salary\n");

            String[][] employees = {
                    {"1", "Alice", "alice@example.com", "60000"},
                    {"2", "Bob", "bob@example.com", "50000"},
                    {"3", "Charlie", "charlie@example.com", "70000"}
            };

            for (String[] emp : employees) {
                writer.write(emp[0] + "," + emp[1] + "," +
                        encrypt(emp[2]) + "," + encrypt(emp[3]) + "\n");
            }

            System.out.println("Encrypted CSV written to: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Read and decrypt CSV
    public static void readDecryptedCSV(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = reader.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    System.out.println(line); // Print header
                    continue;
                }

                String[] parts = line.split(",");
                System.out.println(parts[0] + "," + parts[1] + "," +
                        decrypt(parts[2]) + "," + decrypt(parts[3]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filePath = "encrypted_employees.csv";

        writeEncryptedCSV(filePath);
        System.out.println("\nDecrypted CSV Data:");
        readDecryptedCSV(filePath);
    }
}

