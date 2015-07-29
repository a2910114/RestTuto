package com.mykhaylenko.messanger.exception;

/**
 * Created by pavlo.mykhaylenko on 7/29/2015.
 */
public class DataNotFoundException extends RuntimeException {

    public DataNotFoundException(String message) {
        super(message);
    }

    public DataNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
