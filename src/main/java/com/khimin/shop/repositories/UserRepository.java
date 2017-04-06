package com.khimin.shop.repositories;

import com.khimin.shop.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by nazar on 4/4/17.
 */
public interface UserRepository extends JpaRepository<User, Long> {
//    List<User> findAllBy(TextCriteria criteria);
}
