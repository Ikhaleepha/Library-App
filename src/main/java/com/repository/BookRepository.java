package com.repository;

import com.entity.Book;
import com.entity.Genre;
import com.entity.Standalone;
import com.entity.Trilogy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.net.PortUnreachableException;
import java.util.*;

@Component
@Repository
public class BookRepository {

    private Map<String, String> seriesIndex = new HashMap<>(
            Map.of(
                    "001","The Broken Earth",
                    "002", "The Last Hours")
    );

    private Map<String,Book> books = new HashMap<>(
        Map.of(
                "01231" , new Standalone("01231", "Java How To Program", Genre.Programming),
                "01232", new Standalone("01232", "A Millionaire Vampire", Genre.Fantasy),
                "01233", new Trilogy("01233", "Fifth Season", Genre.Fantasy, "001"),
                "01234", new Trilogy("01234", "Obelisk Gate", Genre.Fantasy, "001"),
                "01235", new Trilogy("01235", "Stone Sky", Genre.Fantasy, "001"),
                "01236", new Standalone("01236", "Byzantine And Persian Wars", Genre.History),
                "01237", new Standalone("01237", "Make it Stick", Genre.Development),
                "01238", new Trilogy("01238", "Chain of Gold", Genre.Fiction, "002"),
                "01239", new Trilogy("01239", "Chain of Iron", Genre.Fiction, "002"),
                "01240", new Trilogy("01240", "Chain of Thorns", Genre.Fiction, "002")
        )
    );

    private List<Book> bookList = new ArrayList<>(books.values());

    public List<Book> getAllBooks(){
        return bookList;
    }

    public void emptyLibrary(){
        bookList.clear();
    }

    public Book getBook(String isbn){
        return books.get(isbn);
    }

    public void populateLibrary() {
        bookList = new ArrayList<>(books.values());
    }
}
