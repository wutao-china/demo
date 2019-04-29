package io.magicbank.springboot.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "io.magicbank.springboot")
public class SpringBootBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootBootstrap.class);
    }
}
