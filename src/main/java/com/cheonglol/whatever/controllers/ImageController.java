package com.cheonglol.whatever.controllers;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cheonglol.whatever.services.ImageService;
import com.cheonglol.whatever.utils.AppLogger;

@RestController
@RequestMapping("/images")
public class ImageController {

    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImages(@RequestBody Map<String, Object> requestBody) {
        try {
            String base64ImageString = (String) requestBody.get("image");
            byte[] decodedBytes = Base64.getDecoder().decode(base64ImageString);

            String sanitizedFilename = sanitizeFilename(requestBody.get("filename").toString());
            imageService.saveAsBlob(decodedBytes, sanitizedFilename);

            return new ResponseEntity<>("Image uploaded successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/retrieve/{filename}")
    public ResponseEntity<byte[]> retrieveImage(@PathVariable String filename) {
        if (filename.equals("")) {
            throw new IllegalArgumentException("RequestParam is an empty string");
        }
        try {
            byte[] imageData = imageService.retrieveAsBlob(filename);
            return new ResponseEntity<byte[]>(imageData, HttpStatus.OK);
        } catch (Exception e) {
            AppLogger.getLogger().error(String.format(e.getMessage()));
            return null;
            // return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    private String sanitizeFilename(String filename) {
        // Implement your filename sanitization logic here
        return filename.replaceAll("[^a-zA-Z0-9\\.\\-_]", "_");
    }
}
