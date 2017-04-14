package com.khimin.shop;

import com.khimin.shop.models.Product;
import com.khimin.shop.models.Role;
import com.khimin.shop.models.User;
import com.khimin.shop.repositories.ProductRepository;
import com.khimin.shop.repositories.UserRepository;
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
    public CommandLineRunner demo(ProductRepository  productRepository, UserRepository userRepository) {
        return (args) -> {
            productRepository.deleteAll();
            productRepository.save(new Product(5, "id", "Nazar", 50));
            userRepository.deleteAll();
            User admin = new User("admin","nazar.khimin@gmail.com","password");
            admin.setRole(Role.ADMIN);
            User user = new User("user","khimin1719@gmail.com","password");
            admin.setRole(Role.USER);
            userRepository.save(user);
            userRepository.save(admin);
        };
    }
}

