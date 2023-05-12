package com.example.springmicroservice.productservice.repository;

import com.example.springmicroservice.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
