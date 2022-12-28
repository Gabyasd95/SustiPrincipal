package com.example.sustigabi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SustiGabiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SustiGabiApplication.class, args);
    }

}
