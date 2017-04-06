package com.khimin.shop;

import com.khimin.shop.models.*;
import com.khimin.shop.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringProjectApplication {

    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringProjectApplication.class, args);
    }

    @PostConstruct
    public void initial() {

        userRepository.deleteAll();
        userRepository.save(new User("Nazar", "Khimin", "khimin1719@gmail.com", "123456", "Ukraine"));
        userRepository.save(new User("Nazar", "Khimin", "khimin1719@gmail.com", "123456", "Ukraine"));
        userRepository.save(new User("Nazar", "Khimin", "khimin1719@gmail.com", "123456", "Ukraine"));
    }
}
