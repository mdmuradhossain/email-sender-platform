package io.murad.email_sender_platform.utils;

import com.opencsv.CSVReader;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Component
public class ReadFromFile {
    public String[] readEmailsFromCSV(String csvFilePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(csvFilePath));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] emailList = line.split(",");
//             String emailAddress = emailData[0]; // Assuming email address is in the first column of the CSV
//            return emailAddress;
            return emailList;
        }
        reader.close();
        return null;
    }

    public List<String[]> readAllEmails(String filePath) throws Exception {
        try (Reader reader = Files.newBufferedReader(Path.of(filePath))) {
            try (CSVReader csvReader = new CSVReader(reader)) {
                return csvReader.readAll();
            }
        }
    }

}

