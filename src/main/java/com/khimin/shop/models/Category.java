package com.khimin.shop.models;

/**
 * Created by khimin on 06.05.17.
 */

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category" )
    private List<Product> goods;

    public Category(String name) {
        this.name = name;
    }

    public void addProduct(Product product) {
//        product.setUser(this);
        goods.add(product);
    }
}
