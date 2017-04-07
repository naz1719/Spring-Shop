package com.khimin.shop.models;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Product entity.
 */
@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Integer version;

    private String productId;
    private String name;
    private BigDecimal price;


}
