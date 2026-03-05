package com.shubham.BookAPI.Service;

import com.shubham.BookAPI.Model.Book;
import com.shubham.BookAPI.Repository.BookRepository;
import com.shubham.BookAPI.exception.bookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book getBookById(Long id){
         return bookRepository.findById(id).orElseThrow(() -> new bookNotFoundException(id));
    }

    public Book saveBook(Book book){
        return bookRepository.save(book);


    }

}
