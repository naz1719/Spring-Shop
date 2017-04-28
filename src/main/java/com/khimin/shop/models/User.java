package com.khimin.shop.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;

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

    public User(String username, String email, String password, Role role, boolean isAccountNonLocked) {
        this.username = username;
        this.email = email;
        this.password = new BCryptPasswordEncoder().encode(password);
        this.role = role;
        this.isAccountNonLocked=isAccountNonLocked;
    }

}
