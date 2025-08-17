package com.spring.ecomers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class EComersApplication {

    public static void main(String[] args) {
        SpringApplication.run(EComersApplication.class, args);
    }

}
