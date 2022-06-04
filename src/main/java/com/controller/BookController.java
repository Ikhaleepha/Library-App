package com.controller;

import com.entity.Book;
import com.error.BookNotFoundException;
import com.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping(path="/")
    public String welcomePage(){
        return "Welcome to Mam's Library";
    }

    @GetMapping(path="/books")
    public List<Book> getAllBooks(){
        //bookService.populateLibrary();
        return bookService.getAllBooks();
    }

    @GetMapping(path = "/books/{isbn}")
    public Book getBook(@PathVariable String isbn) throws BookNotFoundException {
        Book book = bookService.getBook(isbn);
        if(book == null)
            throw new BookNotFoundException();

        return book;
    }
/*
    @PutMapping(path = "/books/borrow/{isbn}")
    public String borrowBook(@PathVariable String isbn){
        return bookService.borrowBook(isbn);
    }

    @PutMapping(path = "/books/return/{isbn}")
    public String returnBook(@PathVariable String isbn){
        return bookService.returnBook(isbn);
    }*/
}
