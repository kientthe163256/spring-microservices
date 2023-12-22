package com.example.springmicroservice.productservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "category")
@Data
public class Category {
    @Id
    private String id;

    @Indexed(unique = true)
    private String name;

    public Category(String name) {
        this.name = name;
    }
}
