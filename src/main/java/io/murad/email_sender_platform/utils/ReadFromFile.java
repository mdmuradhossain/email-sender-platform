package io.murad.email_sender_platform.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFromFile {
    public String sendEmailsFromCSV(String csvFilePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(csvFilePath));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] emailData = line.split(",");
            String emailAddress = emailData[0]; // Assuming email address is in the first column of the CSV
            return emailAddress;
        }
        reader.close();
        return null;
    }

}

