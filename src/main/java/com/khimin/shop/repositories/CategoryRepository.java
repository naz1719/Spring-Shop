package com.khimin.shop.repositories;

import com.khimin.shop.models.Category;
import com.khimin.shop.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by khimin on 07.05.17.
 */
@RepositoryRestResource
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
