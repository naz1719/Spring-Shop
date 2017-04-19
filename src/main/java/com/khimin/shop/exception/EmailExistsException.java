package com.khimin.shop.exception;

/**
 * Created by nazar on 4/18/17.
 */
public class EmailExistsException extends Exception {
    public EmailExistsException() {
        super();
    }

    public EmailExistsException(String message) {
        super(message);
    }
}
