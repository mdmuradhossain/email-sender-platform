package io.murad.email_sender_platform.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
@Component
public class UploadEmailFile {
    public String uploadFile(MultipartFile file) throws IOException {
        String filePath = "";
        Path uploadPath = Paths.get("uploads/");
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
            System.out.println("Path: "+uploadPath.toAbsolutePath());
        }

        try (InputStream inputStream = file.getInputStream()) {
            Path emailsFilePath = uploadPath.resolve(file.getOriginalFilename());
            filePath = emailsFilePath.toFile().getAbsolutePath();
//            System.out.println("Path: " + emailsFilePath.toFile().getAbsolutePath());
            Files.copy(inputStream, emailsFilePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new IOException("could not save");
        }
        return filePath;
    }
}
