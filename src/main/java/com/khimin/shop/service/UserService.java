package com.khimin.shop.service;

import com.khimin.shop.exception.EmailExistsException;
import com.khimin.shop.models.Product;
import com.khimin.shop.models.User;
import com.khimin.shop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by nazar on 4/18/17.
 */
@Service
public class UserService implements UserServiceImpl{

    @Autowired
    UserRepository userRepository;


    @Override
    @Transactional
    public User registerNewUserAccount(User userDTO)
            throws EmailExistsException {

        if (emailExist(userDTO.getEmail())) {
            throw new EmailExistsException("email address already exists: "  + userDTO.getEmail());
        }

        return userRepository.save(userDTO);
    }
    private boolean emailExist(String email) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            return true;
        }
        return false;
    }
}
