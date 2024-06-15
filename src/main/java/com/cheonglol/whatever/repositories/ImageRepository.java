package com.cheonglol.whatever.repositories;

import com.cheonglol.whatever.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface ImageRepository extends JpaRepository<Image, Long> {

    Image findByImageName(@Param("imageName") String imageName);

    void deleteByImageName(@Param("imageName") String imageName);

}
