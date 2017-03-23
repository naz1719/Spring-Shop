package com.khimin.shop.repositories;

import com.khimin.shop.models.Category;
import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by nazar on 3/8/17.
 */
public interface CategoryRepository extends CrudRepository<Category,ObjectId> {
}
