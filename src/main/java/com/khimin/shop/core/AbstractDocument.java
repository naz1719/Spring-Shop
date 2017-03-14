package com.khimin.shop.core;

import lombok.EqualsAndHashCode;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

/**
 * Base class for document classes.
 * Created by nazar on 3/14/17.
 */
@EqualsAndHashCode
public class AbstractDocument {
    @Id
    private ObjectId id = new ObjectId();

    public ObjectId getId() {
        return id;
    }
}
