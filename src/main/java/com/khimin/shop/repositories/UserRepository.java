package com.khimin.shop.repositories;

import com.khimin.shop.models.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by nazar on 4/4/17.
 */
public interface UserRepository extends MongoRepository<User, ObjectId> {
    List<User> findAllBy(TextCriteria criteria);
}
