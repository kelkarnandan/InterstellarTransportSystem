package com.interstellar.transport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class InterstellarTransportSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(InterstellarTransportSystemApplication.class, args);
    }

}
