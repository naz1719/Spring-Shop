package com.khimin.shop.entities;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Product entity.
 */
@Data
@Document
public class Product {

	@Id
	ObjectId id = new ObjectId();

	@Version
	private Integer version;

	private String productId;
	@Indexed
	private String name;
	private int price;

	public Product() {
	}

	public Product(Integer version, String productId, String name, int price) {
		this.version = version;
		this.productId = productId;
		this.name = name;
		this.price = price;
	}
}
