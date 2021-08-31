package com.spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.spring.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, Integer> {

}
