package com.example.springmicroservice.productservice.service;

import com.example.springmicroservice.productservice.dto.ProductRequest;
import com.example.springmicroservice.productservice.dto.ProductResponse;
import com.example.springmicroservice.productservice.mapper.ProductMapper;
import com.example.springmicroservice.productservice.model.Category;
import com.example.springmicroservice.productservice.model.Product;
import com.example.springmicroservice.productservice.repository.CategoryRepository;
import com.example.springmicroservice.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductMapper productMapper;
    private final MongoTemplate mongoTemplate;

    public ProductResponse createProduct(ProductRequest productRequest){
        Optional<Category> categoryOptional = categoryRepository.findById(productRequest.getCategoryId());
        if (categoryOptional.isEmpty()) throw new RuntimeException("Category Not Found");

        Product product = Product.builder()
                .category(categoryOptional.get())
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        Product savedProduct = productRepository.insert(product);
        return productMapper.mapToProductResponse(savedProduct);
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(productMapper::mapToProductResponse)
                .collect(Collectors.toList());
    }
}
