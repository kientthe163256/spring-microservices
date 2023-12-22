package com.example.springmicroservice.productservice.repository;

import com.example.springmicroservice.productservice.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends MongoRepository<Category, String> {
    @Query("{name : {$regex : '?0', '$options' : 'i'}}")
    List<Category> findByName(String name);
}
