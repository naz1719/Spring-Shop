package com.khimin.shop.entities;

import com.khimin.shop.core.AbstractDocument;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by nazar on 3/7/17.
 */
@EqualsAndHashCode(callSuper = false)
@Data
@Document(collection = "products")
public class Category extends AbstractDocument{

    private String name;
}
