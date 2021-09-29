package co.vinod.training;

import co.vinod.training.entity.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;


// @Component -- generic
// @Service -- business logic class
// @Repository -- DAO class
// @Controller @RestController -- Web layer class
// @Configuration -- configuration class

@Slf4j
@Service // instructs sprint to automatically create an instance of this class and keep in the container
public class BookService {
    private Map<Integer, Book> books = new LinkedHashMap<>();

    public BookService(){
        log.info("BookService instantiated!");
        Book b1;
        b1 = new Book(19, "Let us C", Arrays.asList("Y Kanitkar"), 299., 150);
        books.put(b1.getId(), b1);

        b1 = new Book(22, "Let us C++", Arrays.asList("John", "Jane"), 390.0, 250);
        books.put(b1.getId(), b1);

        b1 = new Book(12, "Let us Spring boot", Arrays.asList("Vinod", "Kumar", "Kayartaya"), 800., 999);
        books.put(b1.getId(), b1);
    }

    public Iterable<Book> getAllBooks(){
        return books.values(); // Collection extends Iterable
    }

    public Book getById(Integer id){
        return books.get(id);
    }
}
