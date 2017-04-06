package com.khimin.shop;

import com.khimin.shop.models.User;
import com.khimin.shop.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
public class JpaTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void readsFirstPageCorrectly() {
        Page<User> persons = userRepository.findAll(new PageRequest(0, 10));
        assertThat(persons.isFirst(), is(true));
    }

    @Test
    public void testMongoOpertation() {
        User nazar = new User("Nazar", "Khimin", "khimin1719@gmail.com", "123456", "Ukraine");
        userRepository.exists(nazar.getId());
    }
}

