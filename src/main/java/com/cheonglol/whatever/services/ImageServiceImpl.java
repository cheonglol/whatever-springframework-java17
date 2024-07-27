package com.cheonglol.whatever.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import jakarta.transaction.Transactional;

import com.cheonglol.whatever.models.Image;
import com.cheonglol.whatever.repositories.ImageRepository;

import java.io.ByteArrayOutputStream;

/*
 * EXAMPLE CODE

import org.hibernate.annotations.QueryAnnotation;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.ByteArrayOutputStream;
import java.util.List;

public class ImageServiceImpl implements ImageService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public byte[] retrieveImageAsStream(String imageName) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Query query = entityManager.createNativeQuery("SELECT imageData FROM IMAGES WHERE imageName = :imageName");
        query.setParameter("imageName", imageName);

        List<Object[]> results = query.getResultList();
        for (Object[] result : results) {
            byte[] imageData = (byte[]) result[0];
            outputStream.write(imageData);
        }

        return outputStream.toByteArray();
    }
}

 */

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

    // @Override
    // public byte[] retrieveAsBlob(String imageName) {
    // try {
    // Image image = imageRepository.findByImageName(imageName);
    // if (image == null) {
    // throw new IllegalArgumentException("Image not found");
    // }
    // return image.getImageData();
    // } catch (IllegalArgumentException | NullPointerException e) {
    // // Handle case where image is not found or other unexpected issues
    // System.err.println("Error retrieving image: " + e.getMessage());
    // return null;
    // }
    // }

    @Override
    public byte[] retrieveImage(String imageName) {
        try {
            Image image = imageRepository.findByImageName(imageName);
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
