package com.khimin.shop.service;

import com.khimin.shop.exception.EmailExistsException;
import com.khimin.shop.models.Role;
import com.khimin.shop.models.User;
import com.khimin.shop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by nazar on 4/18/17.
 */
@Service
public class UserService {
    UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public void setbCryptPasswordEncoder(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Transactional
    public User registerNewUserAccount(User user)
            throws EmailExistsException {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new EmailExistsException("email address already exists: " + user.getEmail());
        }
        user.setUsername(user.getUsername());
        user.setEmail(user.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        user.setIsAccountNonLocked(Boolean.TRUE);

        return userRepository.save(user);
    }

}
