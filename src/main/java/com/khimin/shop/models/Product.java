package com.khimin.shop.models;

import com.khimin.shop.core.AbstractDocument;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Product entity.
 */

@EqualsAndHashCode(callSuper = false)
@Data
@Document(collection = "products")
public class Product extends AbstractDocument {

    @TextIndexed(weight = 3)
    private String name;
    private Integer price;
    private Category category;


    public Product() {
    }

    @PersistenceConstructor
    public Product(String name, Integer price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
}
