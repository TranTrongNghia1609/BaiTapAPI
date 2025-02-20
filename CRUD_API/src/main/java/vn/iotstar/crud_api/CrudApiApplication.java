package vn.iotstar.crud_api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.iotstar.crud_api.service.IStorageService;

@SpringBootApplication
public class CrudApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudApiApplication.class, args);
    }
    // thêm cấu hình storage
    @Bean
    CommandLineRunner init(IStorageService storageService) {
        return (args -> {
            storageService.init();
        });
    }

}
