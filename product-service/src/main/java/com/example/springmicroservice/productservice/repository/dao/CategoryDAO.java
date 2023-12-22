package com.example.springmicroservice.productservice.repository.dao;

import com.example.springmicroservice.productservice.model.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.regex.Pattern;

@Repository
@RequiredArgsConstructor
public class CategoryDAO {
    private final MongoTemplate mongoTemplate;

    public List<Category> findCategoryByName(String name){
        Query query = new Query();
        Pattern pattern = Pattern.compile(Pattern.quote(name), Pattern.CASE_INSENSITIVE);
        Criteria c = Criteria.where("name").regex(pattern);
        return mongoTemplate.find(new Query(c), Category.class);
    }
}
