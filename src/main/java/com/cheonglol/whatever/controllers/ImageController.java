package com.cheonglol.whatever.controllers;

import java.util.Base64;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cheonglol.whatever.logging.AppLogger;
import com.cheonglol.whatever.models.ResponseDTO;
import com.cheonglol.whatever.services.ImageService;
import com.cheonglol.whatever.utils.Helper;

@RestController
@RequestMapping("/images")
public class ImageController {

    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/upload")
    public ResponseEntity<ResponseDTO> uploadImages(@RequestBody Map<String, Object> requestBody) {
        try {
            String base64ImageString = (String) requestBody.get("image");
            byte[] decodedBytes = Base64.getDecoder().decode(base64ImageString);

            String sanitizedFilename = Helper.sanitizeFilename(requestBody.get("filename").toString());
            imageService.saveAsBlob(decodedBytes, sanitizedFilename);

            return new ResponseEntity<ResponseDTO>(new ResponseDTO(true, null, sanitizedFilename + " uploaded"),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<ResponseDTO>(new ResponseDTO(false, null,
                    "The server has received the upload request, but failed to upload into the database."),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/retrieve")
    public ResponseEntity<byte[]> retrieveImage(@RequestParam String uniqueIdentifier) {
        try {
            // byte[] imageData = imageService.retrieveAsBlob(filename);
            byte[] imageData = imageService.retrieveImage(UUID.fromString(uniqueIdentifier));
            System.out.println(imageData.toString());
            return new ResponseEntity<byte[]>(imageData, HttpStatus.OK);
        } catch (Exception e) {
            AppLogger.getLogger().error(String.format(e.getMessage()));
            return null;
            // return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
