package com.spring.ecomers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//No se para qye es esto
@EnableJpaRepositories(basePackages = "com.spring.ecomers.repository") /// Activa la configuración automática de Spring Boot
public class EComersApplication {

    public static void main(String[] args) {
        SpringApplication.run(EComersApplication.class, args);
    }
}