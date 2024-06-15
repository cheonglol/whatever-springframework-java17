import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer {

    @PersistenceContext
    private EntityManager entityManager;

    @Bean
    public CommandLineRunner initializeDatabase() {
        return args -> {
            initializeSchema();
            initializeData();
        };
    }

    @Transactional
    public void initializeSchema() {
        entityManager.createNativeQuery("CREATE TABLE IF NOT EXISTS IMAGES (" +
                "id BIGINT AUTO_INCREMENT PRIMARY KEY, " +
                "imageName VARCHAR(255) NOT NULL, " +
                "imageData BLOB)").executeUpdate();
    }

    @Transactional
    public void initializeData() {
        Long imageCount = (Long) entityManager.createQuery("SELECT COUNT(i) FROM Image i").getSingleResult();
        if (imageCount == 0) {
            // Example data insertion
            entityManager.persist(new Image("example_image_name", "example_image_data".getBytes()));
        }
    }
}
