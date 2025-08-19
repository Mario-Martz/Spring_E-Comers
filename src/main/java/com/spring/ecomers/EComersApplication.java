package com.spring.ecomers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.spring.ecomers.repository")
public class EComersApplication {

    public static void main(String[] args) {
        SpringApplication.run(EComersApplication.class, args);
    }
}