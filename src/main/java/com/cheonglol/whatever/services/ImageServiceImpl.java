package com.cheonglol.whatever.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.cheonglol.whatever.models.Image;
import com.cheonglol.whatever.repositories.ImageRepository;

import jakarta.transaction.Transactional;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImageRepository imageRepository;

    @Transactional
    public void saveAsBlob(byte[] imageData, String imageName) {
        try {
            imageRepository.save(new Image(imageName, imageData));
        } catch (DataAccessException e) {
            // Log the exception or handle it appropriately
            System.err.println("Error saving image: " + e.getMessage());
        }
    }

    @Override
    public byte[] retrieveImage(UUID uniqueIdentifier) {
        try {
            Image image = imageRepository.findByUniqueIdentifier(uniqueIdentifier);
            if (image == null)
                throw new IllegalArgumentException("Image not found");
            return image.getImageData();
        } catch (IllegalArgumentException | NullPointerException | DataAccessException e) {
            System.err.println("Error retrieving image: " + e.getMessage());
            return null;
        }
    }

    @Override
    public void updateImage(byte[] imageData, String imageName) {
        try {
            Image image = imageRepository.findByImageName(imageName);
            if (image == null)
                throw new IllegalArgumentException("Image not found");
            image.setImageData(imageData); // Ensure setImageData is public in the Image class
            imageRepository.save(image); // Correctly passing an Image object

        } catch (IllegalArgumentException | NullPointerException | DataAccessException e) {
            // Handle exceptions
            System.err.println("Error updating image: " + e.getMessage());
        }
    }

    @Override
    public void deleteImage(String imageName) {
        try {
            Image image = imageRepository.findByImageName(imageName);
            if (image != null) {
                imageRepository.delete(image);
            } else {
                throw new IllegalArgumentException("Image not found");
            }
        } catch (IllegalArgumentException | NullPointerException | DataAccessException e) {
            // Handle exceptions
            System.err.println("Error deleting image: " + e.getMessage());
        }
    }

}
