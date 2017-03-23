package com.khimin.shop.models;

import com.khimin.shop.core.AbstractDocument;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by nazar on 3/7/17.
 */
@EqualsAndHashCode(callSuper = false)
@Data
@Document(collection = "products")
public class Category extends AbstractDocument{

    private String name;
}
