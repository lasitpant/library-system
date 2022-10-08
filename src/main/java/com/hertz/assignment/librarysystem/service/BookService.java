package com.hertz.assignment.librarysystem.service;

import com.hertz.assignment.librarysystem.entity.Book;
import com.hertz.assignment.librarysystem.entity.BookDTO;
import com.hertz.assignment.librarysystem.entity.Category;
import com.hertz.assignment.librarysystem.exceptions.NotFoundException;
import com.hertz.assignment.librarysystem.repository.BookRepository;
import com.hertz.assignment.librarysystem.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookService {

    private BookRepository bookRepository;
    private CategoryRepository categoryRepository;

    public BookService(BookRepository bookRepository,

                       CategoryRepository categoryRepository){
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
    }

    public Book addBook(BookDTO payload) {
      final var checkRecord = bookRepository.findBookByISBN(payload.getIsbn());
      if (!checkRecord.isEmpty()){
            throw new NotFoundException("Book Exists with same ISBN.");
        }
        final var data = createBookObject(payload);
        return bookRepository.save(data);
    }

    public void deleteBook(Long id){
        bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Record not found !"));
        bookRepository.delete(bookRepository.getReferenceById(id));
    }

    public Book getBookById(Long id){
        return bookRepository.getReferenceById(id);
    }

    public List<Book> getAll(){
        return bookRepository.findAll();
    }

    public List<Book> search(String searchValue){
        return bookRepository.findBookByTitle(searchValue);
    }


    Book createBookObject(BookDTO payload){
        Book book = new Book();

        book.setISBN(payload.getIsbn());
        book.setTitle(payload.getTitle());
        book.setSubject(payload.getSubject());
        book.setLanguage(payload.getLanguage());
        book.setNumberOfPages(payload.getNumberOfPages());

        Set<Category> categoryPayload = new HashSet<>();
        payload.getCategories().forEach(d->{
            categoryPayload.add(categoryRepository.findById(d).orElseThrow(()-> new NotFoundException("Category not found !")));
        });
        book.setCategories(categoryPayload);
        book.setAvailability(true);
        return book;
    }
}
