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
    public User findOne(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public Page<User> findAllbyPage(Pageable pageable) {
        return userRepository.findAll( pageable);
    }
    @Override
    public void delete(Long id){
         userRepository.delete(id);
    }
    @Override
    @Transactional
    public User registerNewUserAccount(User userDTO)
            throws EmailExistsException {

        if (emailExist(userDTO.getEmail())) {
            throw new EmailExistsException("email address already exists: "  + userDTO.getEmail());
        }
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setRole(userDTO.getRole());
        return userRepository.save(user);
    }
    private boolean emailExist(String email) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            return true;
        }
        return false;
    }

}
