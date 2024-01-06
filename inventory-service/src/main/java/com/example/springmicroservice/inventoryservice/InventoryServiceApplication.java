package com.example.springmicroservice.inventoryservice;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Value("${spring.datasource.url}")
    private String url;

    @PostConstruct
    public void init() {
        System.out.println("----------------AFTER INIT--URL---------------" + url);
        try {
            Connection connection = DriverManager.getConnection(url, "root", "123456");
            System.out.println("------------------URL---------------" + url);
            System.out.println("Connect successfully");
        } catch (SQLException e) {
            System.out.println("--------------------------------FAILED------------------");
            throw new RuntimeException(e);
        }
    }
}
