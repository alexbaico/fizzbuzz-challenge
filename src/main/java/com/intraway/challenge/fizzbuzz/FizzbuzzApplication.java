package com.intraway.challenge.fizzbuzz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FizzbuzzApplication {

    public static void main(String[] args) {
        SpringApplication.run(FizzbuzzApplication.class, args);
    }

}
