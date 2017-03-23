package com.khimin.shop;

import com.khimin.shop.models.*;
import com.khimin.shop.repositories.CategoryRepository;
import com.khimin.shop.repositories.CustomerRepository;
import com.khimin.shop.repositories.OrderRepository;
import com.khimin.shop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringProjectApplication {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CategoryRepository categoryRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringProjectApplication.class, args);
    }

    @PostConstruct
    public void initial() {
        productRepository.deleteAll();
        orderRepository.deleteAll();
        customerRepository.deleteAll();
        Category category = new Category();
        category.setName("t-shirt");
        productRepository.save(new Product("Barbuer", 2000, category));
        productRepository.save(new Product("Lacosta", 2000, category));
        Address OrestAddress = new Address("Lviv","Gasheka 15a","03907");
        Customer OrestCustomer = new Customer("Orest","Bobko",OrestAddress);
        Order order = new Order();
        order.setCustomer(OrestCustomer);
        order.add(new Product("Barbuer", 2000, category));
        order.add(new Product("Lacosta", 2000, category));
        orderRepository.save(order);
    }
}
