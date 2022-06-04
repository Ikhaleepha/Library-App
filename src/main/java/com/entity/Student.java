package com.entity;

import com.repository.BookRepository;

import java.util.HashSet;
import java.util.Set;

public class Student {

    private String id;
    Set<Book> borrowBooks = new HashSet<>();

    public Student(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<Book> getBorrowBooks() {
        return borrowBooks;
    }

    public void setBorrowBooks(Set<Book> borrowBooks) {
        this.borrowBooks = borrowBooks;
    }


}
