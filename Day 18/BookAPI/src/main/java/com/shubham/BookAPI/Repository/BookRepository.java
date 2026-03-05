package com.shubham.BookAPI.Repository;

import com.shubham.BookAPI.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import com.shubham.BookAPI.Model.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long>{

    List<Book> findByAuthor(String author);



}
