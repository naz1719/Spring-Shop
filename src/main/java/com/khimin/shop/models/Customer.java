/*
 * Copyright 2014 the original author or authors.
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
import lombok.*;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.Assert;

/**
 * An entity to represent a customer.
 */
@EqualsAndHashCode(callSuper = false)
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Document(collection = "customers")
public class Customer extends AbstractDocument {

    private String firstname, lastname;
    private Address address;

    @PersistenceConstructor
    public Customer(String firstname, String lastname, Address address) {
        Assert.hasText(firstname, "Firstname must not be null or empty!");
        Assert.hasText(lastname, "Lastname must not be null or empty!");
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
    }
}
