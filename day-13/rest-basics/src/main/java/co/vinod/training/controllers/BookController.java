package co.vinod.training.controllers;

import co.vinod.training.BookService;
import co.vinod.training.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class BookController {

    // dependency can be wired by spring automatically
    @Autowired
    BookService service; // default value for this is null;

    @GetMapping
    public Iterable<Book> handleGetRequest(){
        return service.getAllBooks();
    }

    // http://localhost:8080/api/books/12
    @GetMapping("/{id}")
    public Book handleGetBookById(@PathVariable("id") Integer id){
        return service.getById(id);
    }
}
