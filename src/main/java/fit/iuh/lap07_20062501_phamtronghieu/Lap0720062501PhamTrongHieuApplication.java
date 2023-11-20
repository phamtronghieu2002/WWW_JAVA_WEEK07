package fit.iuh.lap07_20062501_phamtronghieu;

import fit.iuh.lap07_20062501_phamtronghieu.enums.ProductStatus;
import fit.iuh.lap07_20062501_phamtronghieu.models.Product;
import fit.iuh.lap07_20062501_phamtronghieu.repositories.ProductRepository;
import net.datafaker.Faker;
import net.datafaker.providers.base.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import java.util.Random;

@SpringBootApplication
public class Lap0720062501PhamTrongHieuApplication   {

    public static void main(String[] args) {

        SpringApplication.run(Lap0720062501PhamTrongHieuApplication.class, args);
}

    @Autowired
    private ProductRepository productResponsitory;

    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            Faker faker = new Faker();
            Random rnd = new Random();
            Device devices = faker.device();
            Product product = null;
            for (int i = 0; i < 200; i++) {
                product = new Product(devices.modelName(), faker.lorem().paragraph(30), "piece", devices.manufacturer(), ProductStatus.ACTIVE);
                productResponsitory.save(product);
            }

        };


    }
}
