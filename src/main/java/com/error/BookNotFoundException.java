package com.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class BookNotFoundException extends EntityNotFoundException{
    public BookNotFoundException(){
        super("Book Does Not Exist!");
    }
}
