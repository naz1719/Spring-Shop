package com.khimin.shop;

import com.khimin.shop.entities.Customer;
import com.khimin.shop.entities.Product;
import com.khimin.shop.repositories.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by nazar on 3/7/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoTest {

    @Autowired
    ProductRepository productRepository;
    @Test
    public void readsFirstPageCorrectly() {
        Page<Product> persons = productRepository.findAll(new PageRequest(0, 10));
        assertThat(persons.isFirst(), is(true));
    }
    @Test
    public void testMongoOpertation(){
        Customer orest = new Customer("Orest","Bobko", null);
        productRepository.exists(orest.getId());
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIncludeNullValues();
        Example<Customer> example = Example.of(orest, matcher);
    }
}

