package com.khimin.shop.textsearch;

import com.khimin.shop.entities.Product;
import com.khimin.shop.repositories.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.khimin.shop.util.ConsoleResultPrinter.printResult;


/**
 * Created by nazar on 3/11/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TextSearchRepositoryTests {
    @Autowired
    ProductRepository productRepository;

    @Test
    public void findAllBlogPostsWithRelease() {

        TextCriteria criteria = TextCriteria.forDefaultLanguage().matchingAny("Barbuer");
        List<Product> products = productRepository.findAllBy(criteria);

        printResult(products, criteria);
    }

}
