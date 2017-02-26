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

	@Id
	ObjectId id = new ObjectId();

	@Version
	private Integer version;
	@Indexed
	private String name;
	private int price;


	public Product() {
	}

	@PersistenceConstructor
	public Product(Integer version, String name, int price) {
		this.version = version;
		this.name = name;
		this.price = price;
	}
}
