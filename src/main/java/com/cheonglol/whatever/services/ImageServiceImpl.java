package com.cheonglol.whatever.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cheonglol.whatever.models.Image;
import com.cheonglol.whatever.repositories.ImageRepository;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImageRepository imageRepository;

    public void saveAsBlob(byte[] imageData, String imageName) {
        Image image = new Image();
        image.setImageName(imageName);
        image.setImageData(imageData);
        imageRepository.save(image);
    }

    public byte[] retrieveAsByteArray(String imageName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'retrieveAsByteArray'");
    }

    @Override
    public byte[] retrieveAsBlob(String imageName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'retrieveAsBlob'");
    }

    @Override
    public void updateImage(byte[] imageData, String imageName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateImage'");
    }

    @Override
    public void deleteImage(String imageName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteImage'");
    }

}
