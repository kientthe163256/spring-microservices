package com.example.springmicroservice.productservice;

import com.example.springmicroservice.productservice.model.Product;
import com.example.springmicroservice.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.math.BigDecimal;

@SpringBootApplication
@EnableDiscoveryClient
@RequiredArgsConstructor
public class ProductServiceApplication implements CommandLineRunner {

    private final ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    @Override
    public void run(String... args) {
//        if (productRepository.count() < 1) {
//            Product product = new Product();
//            product.setName("iPhone 13");
//            product.setDescription("iPhone 13");
//            product.setPrice(BigDecimal.valueOf(1000));
//
//            productRepository.save(product);
//        }
    }
}