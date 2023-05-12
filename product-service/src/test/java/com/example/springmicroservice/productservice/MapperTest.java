package com.example.springmicroservice.productservice;

import com.example.springmicroservice.productservice.dto.ProductResponse;
import com.example.springmicroservice.productservice.mapper.ProductMapper;
import com.example.springmicroservice.productservice.model.Product;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapperTest {
    private ProductMapper mapper = Mappers.getMapper(ProductMapper.class);
    @Test
    public void mapToProductResponseSuccessfully() {
        Product product = Product.builder()
                .name("TestProduct")
                .description("This is a test product")
                .price(BigDecimal.valueOf(100))
                .build();
        ProductResponse productResponse = mapper.mapToProductResponse(product);

        assertEquals(product.getName(), productResponse.getName());
        assertEquals(product.getDescription(),
                productResponse.getDescription());
    }
}
