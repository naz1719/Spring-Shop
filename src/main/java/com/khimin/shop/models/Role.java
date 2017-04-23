package com.khimin.shop.models;

/**
 * Created by nazar on 4/14/17.
 */
public enum Role {
    USER("Role user"),
    ADMIN("Role admin");

    private String description;

    Role(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
