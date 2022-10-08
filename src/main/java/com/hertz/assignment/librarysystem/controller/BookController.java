package com.hertz.assignment.librarysystem.controller;

import com.hertz.assignment.librarysystem.entity.Book;
import com.hertz.assignment.librarysystem.entity.BookDTO;
import com.hertz.assignment.librarysystem.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class BookController {
    private final BookService bookService;

    private BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks(){
        return new ResponseEntity<>(bookService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Long id){
        return new ResponseEntity<>(bookService.getBookById(id), HttpStatus.OK);
    }

    @PostMapping("/add-book")
    public ResponseEntity<Book> createBookRecord(@RequestBody BookDTO requestBody){
        final var payload = bookService.addBook(requestBody);
        return new ResponseEntity<>(payload, HttpStatus.OK);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> removeBook(@PathVariable Long id){
        bookService.deleteBook(id);
        return new ResponseEntity<>("Deleted", HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search/{value}")
    public ResponseEntity<List<Book>> searchByName(@PathVariable String value){
        return new ResponseEntity<>(bookService.search(value), HttpStatus.OK);
    }
}
