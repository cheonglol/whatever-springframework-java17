package com.cheonglol.whatever.services;

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
            Image image = new Image();
            image.setImageName(imageName);
            image.setImageData(imageData);
            imageRepository.save(image);
        } catch (DataAccessException e) {
            // Log the exception or handle it appropriately
            System.err.println("Error saving image: " + e.getMessage());
        }
    }

    public byte[] retrieveAsByteArray(String imageName) {
        try {
            Image image = imageRepository.findByImageName(imageName);
            if (image == null) {
                throw new IllegalArgumentException("Image not found");
            }
            return image.getImageData();
        } catch (IllegalArgumentException | NullPointerException e) {
            // Handle case where image is not found or other unexpected issues
            System.err.println("Error retrieving image: " + e.getMessage());
            return null;
        }
    }

    @Override
    public byte[] retrieveAsBlob(String imageName) {
        return retrieveAsByteArray(imageName);
    }

    @Override
    public void updateImage(byte[] imageData, String imageName) {
        try {
            Image image = imageRepository.findByImageName(imageName);
            if (image != null) {
                image.setImageData(imageData);
                imageRepository.save(image);
            } else {
                throw new IllegalArgumentException("Image not found");
            }
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
