package com.khimin.shop.service;

import com.khimin.shop.exception.EmailExistsException;
import com.khimin.shop.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by nazar on 4/18/17.
 */
public interface UserServiceImpl {
     User registerNewUserAccount(User userDTO) throws EmailExistsException;
}
