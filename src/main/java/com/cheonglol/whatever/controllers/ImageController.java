package com.cheonglol.whatever.controllers;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cheonglol.whatever.services.ImageService;

@RestController
@RequestMapping("/images")
public class ImageController {

    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImages(@RequestParam("demo[]") List<MultipartFile> files) {
        try {
            for (MultipartFile file : files) {
                String originalFilename = file.getOriginalFilename();
                if (originalFilename == null) {
                    continue; // Skip files without a name
                }

                // Simple filename sanitization (consider more robust solutions for production)
                String decodedFilename = URLDecoder.decode(originalFilename, StandardCharsets.UTF_8.name());
                String sanitizedFilename = decodedFilename.replaceAll("[^a-zA-Z0-9\\.\\-_]", "_"); // Basic sanitization

                byte[] bytes = file.getBytes();
                imageService.saveAsBlob(bytes, sanitizedFilename); // Assuming saveAsBlob handles the filename safely
            }
            return new ResponseEntity<>("Images uploaded successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
