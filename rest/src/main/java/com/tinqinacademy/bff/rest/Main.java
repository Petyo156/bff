package com.tinqinacademy.bff.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = "com.tinqinacademy.bff")
@EnableFeignClients(basePackages = {"com.tinqinacademy.bff.domain", "com.tinqinacademy.authentication.restexport",
        "com.tinqinacademy.hotel.restexport", "com.tinqinacademy.comments.restexport"})
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}