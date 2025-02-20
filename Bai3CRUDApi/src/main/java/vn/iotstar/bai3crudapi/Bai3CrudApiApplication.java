package vn.iotstar.bai3crudapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import vn.iotstar.bai3crudapi.config.StorageProperties;
import vn.iotstar.bai3crudapi.service.IStorageService;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class) // thêm cấu hình storage
public class Bai3CrudApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(Bai3CrudApiApplication.class, args);

    }
    // thêm cấu hình storage
    @Bean
    CommandLineRunner init(IStorageService storageService) {
        return (args -> {
            storageService.init();
        });
    }

}
