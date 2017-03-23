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
package com.khimin.shop.repositories;

import com.khimin.shop.models.Order;
import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;

/**
 * A repository interface assembling CRUD functionality as well as the API to invoke the methods implemented manually.
 * 
 * @author Thomas Darimont
 * @author Oliver Gierke
 */
public interface OrderRepository extends CrudRepository<Order, ObjectId> {}
