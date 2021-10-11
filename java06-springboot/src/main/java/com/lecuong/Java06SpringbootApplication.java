package com.lecuong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Java06SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(Java06SpringbootApplication.class, args);
    }

}
