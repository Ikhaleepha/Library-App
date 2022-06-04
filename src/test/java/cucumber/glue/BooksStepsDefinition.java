package cucumber.glue;

import com.entity.Book;
import com.service.BookService;
import com.service.LibraryService;
import cucumber.CucumberConfiguration;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BooksStepsDefinition {

    List<Book> actualBooks = new ArrayList<>();

    @Autowired
    TestRestTemplate testRestTemplate;

    @Autowired
    LibraryService libraryService;

    String baseUrl = "http://localhost:8080/books";

    @Given("^there are no books in the library$")
    public void thereAreNoBooksInTheLibrary(){
        //bookService.emptyLibrary();
        libraryService.emptyLibrary();

    }

    @When("^i view books in the library$")
    public void iViewBooksInTheLibrary(){
        actualBooks = testRestTemplate.getForObject(baseUrl, List.class);
    }

    @Then("^i see an empty library$")
    public void iSeeAnEmptyLibrary(){
        assertEquals(0, actualBooks.size());
    }

    @Given("^there are books in the library$")
    public void thereAreBooksInTheLibrary(){
        //bookService.populateLibrary();
        libraryService.populateLibrary();
    }

    @When("^i view all books in the library$")
    public void iViewAllBooksInTheLibrary(){
        actualBooks = testRestTemplate.getForObject(baseUrl, List.class);
    }

    @Then("^i see the list of the books in the library$")
    public void iSeetheListOfTheBooksInTheLibrary(){
        assertTrue(0 != actualBooks.size());
    }
}
