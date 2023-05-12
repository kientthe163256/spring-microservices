package com.example.springmicroservice.productservice.service;

import com.example.springmicroservice.productservice.dto.ProductRequest;
import com.example.springmicroservice.productservice.dto.ProductResponse;
import com.example.springmicroservice.productservice.mapper.ProductMapper;
import com.example.springmicroservice.productservice.model.Product;
import com.example.springmicroservice.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;
private final ProductMapper productMapper;
    public void createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
        log.info("Product with id = {} is saved!", product.getId());
    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream().map(productMapper::mapToProductResponse).collect(Collectors.toList());
    }
}
