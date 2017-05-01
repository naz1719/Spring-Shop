package com.khimin.shop.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Product entity.
 */
@Data
@NoArgsConstructor
@Entity
public class Product{

    @Id
    @GeneratedValue
    private Long id;

    @Version
    private Integer version;

    private String productId;
    private String name;
    private Integer price;
    private String photoName;

    public Product(Integer version, String productId, String name, Integer price,String photoName) {
        this.version = version;
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.photoName=photoName;
    }
}
