package com.khimin.shop.models;

import lombok.Data;

import javax.persistence.*;

/**
 * Product entity.
 */
@Data
@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    @Version
    private Integer version;

    private String productId;
    private String name;
    private Integer price;
    private String photoName;

    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;


    public Product(Integer version, String productId, String name, Integer price, String photoName) {
        this.version = version;
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.photoName = photoName;
    }

    public Product() {
    }
}
