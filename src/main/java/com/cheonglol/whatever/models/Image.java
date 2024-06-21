package com.cheonglol.whatever.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "IMAGES")
public class Image {

    @Id
    private Long id;

    private String imageName;

    @Lob
    private byte[] imageData;

    // Constructors, getters, and setters

    public Image() {
    }

    public Image(String imageName, byte[] imageData) {
        this.imageName = imageName;
        this.imageData = imageData;
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
}