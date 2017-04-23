package com.khimin.shop.service;

import com.khimin.shop.exception.EmailExistsException;
import com.khimin.shop.models.User;
import com.khimin.shop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Transactional
    public User registerNewUserAccount(User user)
            throws EmailExistsException {

        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new EmailExistsException("email address already exists: " + user.getEmail());
        }

        return userRepository.save(user);
    }

}
