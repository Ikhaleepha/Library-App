package com.service;

import com.controller.BookController;
import com.entity.Book;
import com.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    public Book getBook(String isbn){
        return bookRepository.getBook(isbn);
    }

    public void emptyLibrary(){
        bookRepository.emptyLibrary();
    }

    public void populateLibrary(){
        bookRepository.populateLibrary();
    }
}
