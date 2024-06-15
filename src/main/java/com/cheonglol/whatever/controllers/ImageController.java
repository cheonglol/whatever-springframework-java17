package com.cheonglol.whatever.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @PostMapping("/{imageName}")
    public ResponseEntity<String> uploadImage(@PathVariable String imageName,
            @RequestParam("file") MultipartFile file) {
        try {
            byte[] bytes = file.getBytes();
            imageService.saveAsBlob(bytes, imageName);
            return new ResponseEntity<>("Image uploaded successfully", HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{imageName}")
    public ResponseEntity<byte[]> downloadImage(@PathVariable String imageName) {
        byte[] imageData = imageService.retrieveAsByteArray(imageName);
        return ResponseEntity.ok().body(imageData);
    }
}