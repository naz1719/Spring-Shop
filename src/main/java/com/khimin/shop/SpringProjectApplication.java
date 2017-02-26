package com.khimin.shop;

import com.khimin.shop.entities.Product;
import com.khimin.shop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringProjectApplication {

    @Autowired
    ProductRepository productRepository;

    public static void main(String[] args)
    {
        SpringApplication.run(SpringProjectApplication.class, args);
    }

    @PostConstruct
    public void initial() {
        Product product =new Product();
        product.setName("Bob");
        product.setPrice(200);
        productRepository.save(product);
    }
}
