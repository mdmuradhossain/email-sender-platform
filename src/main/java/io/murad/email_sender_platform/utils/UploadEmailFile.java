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

    public void uploadFile(MultipartFile file) throws IOException {
        Path uploadPath = Paths.get("uploads/");
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
            System.out.println("Path: "+uploadPath.toAbsolutePath());
        }

        try (InputStream inputStream = file.getInputStream()) {
            Path imagePath = uploadPath.resolve(file.getOriginalFilename());
            System.out.println(imagePath.toFile().getAbsolutePath());
            Files.copy(inputStream, imagePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new IOException("could not save");
        }
    }
}
