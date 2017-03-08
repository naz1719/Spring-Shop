package com.khimin.shop.entities;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by nazar on 3/7/17.
 */
@Data
@Document(collection = "products")
public class Category {
    @Id
    private ObjectId id = new ObjectId();
    private String name;
}
