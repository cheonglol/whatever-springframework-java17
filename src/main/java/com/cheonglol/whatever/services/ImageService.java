package com.cheonglol.whatever.services;

public interface ImageService {

    // Save an image as a BLOB
    void saveAsBlob(byte[] imageData, String imageName);

    // Retrieve an image as a BLOB by its name
    byte[] retrieveAsBlob(String imageName);

    // Update an existing image as a BLOB
    void updateImage(byte[] imageData, String imageName);

    // Delete an image by its name
    void deleteImage(String imageName);

}
