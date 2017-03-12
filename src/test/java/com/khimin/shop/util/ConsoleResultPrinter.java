package com.khimin.shop.util;

import com.khimin.shop.entities.Product;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;

import java.util.Collection;

/**
 * Created by nazar on 3/11/17.
 */
public class ConsoleResultPrinter {
    public static void printResult(Collection<Product> products, CriteriaDefinition criteria) {

        System.out.println(String.format("XXXXXXXXXXXX -- Found %s products matching '%s' --XXXXXXXXXXXX",
                products.size(), criteria != null ? criteria.getCriteriaObject() : ""));
        for (Product product : products) {
            System.out.println(product);
        }

        System.out.println("XXXXXXXXXXXX -- XXXXXXXXXXXX -- XXXXXXXXXXXX\r\n");
    }
}
