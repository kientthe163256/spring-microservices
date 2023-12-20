package com.example.springmicroservice;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {
    @Value("${spring.application.name}")
    private String name;
    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    @PostConstruct
    public void init() {
        System.out.println("--------------APP_NAME===========" + name);
    }
}