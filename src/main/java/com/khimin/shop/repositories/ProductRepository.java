package com.khimin.shop.repositories;


import com.khimin.shop.entities.Product;
import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, ObjectId> {
	List<Product> findByName(String name);

	List<Product> findByNameLike(String name);
}
