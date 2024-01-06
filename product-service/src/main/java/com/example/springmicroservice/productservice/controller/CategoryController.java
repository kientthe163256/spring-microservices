package com.example.springmicroservice.productservice.controller;

import com.example.springmicroservice.productservice.model.Category;
import com.example.springmicroservice.productservice.repository.CategoryRepository;
import com.example.springmicroservice.productservice.repository.dao.CategoryDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryRepository categoryRepository;
    private final CategoryDAO categoryDAO;

    @GetMapping
    public List<Category> findAllCategory(){
        return categoryRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(String name){
        Category category = new Category(name);
        Category savedCategory = categoryRepository.insert(category);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAllCategory(){
        categoryRepository.deleteAll();
        return ResponseEntity.ok("Delete successfully");
    }

    @GetMapping("search")
    public List<Category> searchCategory(@RequestParam String name){
        return categoryDAO.findCategoryByName(name);
    }
}
