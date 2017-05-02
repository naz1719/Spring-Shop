package com.khimin.shop.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by nazar on 4/12/17.
 */
@Data
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    @Column(name = "email", nullable = false, unique = true)
    private String email;
    private String password;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;
    private Boolean isAccountNonLocked;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "USER_PRODUCT", joinColumns = @JoinColumn(name="user_id"),inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Collection<Product> products = new ArrayList<Product>();

    public User(String username, String email, String password, Role role, boolean isAccountNonLocked) {
        this.username = username;
        this.email = email;
        this.password = new BCryptPasswordEncoder().encode(password);
        this.role = role;
        this.isAccountNonLocked = isAccountNonLocked;
    }

//    public void addProduct(Product product) {
//        product.setUser(this);
//        products.add(product);
//    }
}
