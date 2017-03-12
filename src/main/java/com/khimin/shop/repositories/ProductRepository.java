package com.khimin.shop.repositories;


import com.khimin.shop.entities.Product;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProductRepository extends PagingAndSortingRepository<Product, ObjectId> {
    List<Product> findAllBy(TextCriteria criteria);
}