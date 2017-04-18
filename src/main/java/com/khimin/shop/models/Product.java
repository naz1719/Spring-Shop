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
public class Product extends AbstractPersistable<Long> {


    @Version
    private Integer version;

    private String productId;
    private String name;
    private Integer price;

    public Product(Integer version, String productId, String name, Integer price) {
        this.version = version;
        this.productId = productId;
        this.name = name;
        this.price = price;
    }
}
