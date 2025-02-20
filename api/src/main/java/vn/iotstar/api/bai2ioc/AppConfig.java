package vn.iotstar.api.bai2ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public HelloWord helloWorld() {
        HelloWord helloWorld = new HelloWord();
        helloWorld.setMessage("Hello Spring Boot!");
        return helloWorld;
    }
}