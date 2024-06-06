package com.ratanit.emailapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class FileUploadController {

    private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    @Value("${file.upload-dir}")
    private String uploadDir;

    @PostMapping("/upload")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
        System.out.println("Test Changes in git Hub in FileUploadController");
        try {
            Path uploadPath = Paths.get(uploadDir);

            // Create directories if they don't exist
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            // Construct the file path
            Path filePath = uploadPath.resolve(file.getOriginalFilename());

            // Print the file name to the console
            System.out.println("Received file: " + file.getOriginalFilename());
            // Or use a logger to log the file name
            logger.info("Received file: " + file.getOriginalFilename());

            // Transfer the file to the constructed path
            file.transferTo(filePath.toFile());

            return ResponseEntity.ok("File uploaded successfully: " + file.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file");
        }
    }
}

