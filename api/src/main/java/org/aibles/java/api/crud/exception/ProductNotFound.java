package org.aibles.java.api.crud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFound extends Exception{
    public ProductNotFound(String message) {
        super(message);
    }
}
