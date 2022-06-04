package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryService {

    @Autowired
    BookService bookService;

    public void emptyLibrary(){
        bookService.emptyLibrary();
    }

    public void populateLibrary(){
        bookService.populateLibrary();
    }
}
