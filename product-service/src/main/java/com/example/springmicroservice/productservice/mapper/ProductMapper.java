package com.example.springmicroservice.productservice.mapper;

import com.example.springmicroservice.productservice.dto.ProductRequest;
import com.example.springmicroservice.productservice.dto.ProductResponse;
import com.example.springmicroservice.productservice.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductResponse mapToProductResponse(Product product);
    Product mapToProduct(ProductRequest productRequest);
}
