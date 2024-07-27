package com.cheonglol.whatever.repositories;

import com.cheonglol.whatever.models.Image;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface ImageRepository extends JpaRepository<Image, Long> {

    Image findByImageName(@Param("imageName") String imageName);

    Image findByUniqueIdentifier(@Param("uniqueIdentifier") UUID uniqueIdentifier);

    void deleteByImageName(@Param("imageName") String imageName);

}
