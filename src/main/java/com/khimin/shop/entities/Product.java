package com.khimin.shop.entities;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Product entity.
 */

@Data
@Document(collection = "products")
public class Product {

	@Id private ObjectId id = new ObjectId();

	@Indexed
	private String name;
	private int price;
	private Category category;


	public Product() {
	}

	@PersistenceConstructor
	public Product(String name, int price,Category category) {
		this.name = name;
		this.price = price;
		this.category=category;

	}
}
