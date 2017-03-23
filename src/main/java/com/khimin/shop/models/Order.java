/*
 * Copyright 2013-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.khimin.shop.models;

import com.khimin.shop.core.AbstractDocument;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;

/**
 * An entity representing an {@link Order}. Note how we don't need any MongoDB mapping annotations as {@code id} is
 * recognized as the id property by default.
 */
@EqualsAndHashCode(callSuper = false)
@Data
@RequiredArgsConstructor(onConstructor = @__(@PersistenceConstructor))
@Document(collection = "orders")
public class Order extends AbstractDocument {
    private Customer customer;
    private Set<Product> items = new HashSet<Product>();
    private Date orderDate = new Date();


    /**
     * Adds the given {@link Product} to the {@link Order}.
     *
     * @param items
     */
    public void add(Product items) {
        this.items.add(items);
    }
}
