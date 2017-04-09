package com.khimin.shop;

import com.khimin.shop.models.Product;
import com.khimin.shop.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringProjectApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(ProductRepository repository) {
        return (args) -> {
            repository.deleteAll();
            repository.save(new Product(5, "id", "Nazar", 50));
        };
    }
}

