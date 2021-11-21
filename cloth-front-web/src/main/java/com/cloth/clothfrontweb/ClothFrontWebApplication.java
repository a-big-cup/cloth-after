package com.cloth.clothfrontweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(value = "com.cloth.clothfrontweb.commonmodel")
@SpringBootApplication
public class ClothFrontWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClothFrontWebApplication.class, args);
    }

}
