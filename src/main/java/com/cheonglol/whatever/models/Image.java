package com.cheonglol.whatever.models;

import java.util.UUID;

import com.cheonglol.whatever.utils.Helper;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "IMAGES")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private String imageName;

    @Lob
    private byte[] imageData;

    private String mimeType;

    private UUID uniqueIdentifier;

    // Constructors, getters, and setters
    public Image() {
    }

    public Image(String imageName, byte[] imageData) {
        this.imageName = imageName;
        this.imageData = imageData;
        this.mimeType = Helper.getFuckingFilenameExtention(imageName);
        this.uniqueIdentifier = UUID.randomUUID();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    public void setMimeType(String newValue) {
        this.mimeType = newValue;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setUniqueIdentifier(UUID uniqueIdentifier) {
        this.uniqueIdentifier = uniqueIdentifier;
    }

    public UUID getUniqueIdentifier() {
        return uniqueIdentifier;
    }
}