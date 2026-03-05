package com.shubham.BookAPI.Controller;

import com.shubham.BookAPI.Repository.BookRepository;
import com.shubham.BookAPI.Service.BookService;
import com.shubham.BookAPI.exception.bookException;
import com.shubham.BookAPI.exception.bookNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.shubham.BookAPI.Model.Book;
import com.shubham.BookAPI.Service.BookService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> allBooks (){
        return bookService.getAllBooks();
    }

    @PostMapping("/books")
    public ResponseEntity<Book> saveBook(@Valid @RequestBody  Book book){
        Book savedBook = bookService.saveBook(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);

    }
    @GetMapping("/books/{id}")
    public Book singleBook(@PathVariable long id){
        return bookService.getBookById(id);

    }
}
