package com.hertz.assignment.librarysystem.service;


import com.hertz.assignment.librarysystem.entity.Book;
import com.hertz.assignment.librarysystem.entity.BookDTO;
import com.hertz.assignment.librarysystem.entity.Category;
import com.hertz.assignment.librarysystem.exceptions.LibrarySystemMemberException;
import com.hertz.assignment.librarysystem.exceptions.NotFoundException;
import com.hertz.assignment.librarysystem.repository.BookRepository;
import com.hertz.assignment.librarysystem.repository.CategoryRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private CategoryRepository categoryRepository;

    private BookService bookService;

    @BeforeEach
    void setUp(){
        this.bookService = new BookService(bookRepository, categoryRepository);
    }

    @Test
    @DisplayName("Test find all")
    void testGetAll(){
        bookService.getAll();
        verify(bookRepository).findAll();
    }

    @Test
    @DisplayName("Test create book- Rainy Day")
    void testAddBook(){
        final var bookDTO = new BookDTO();
        Assert.assertThrows(LibrarySystemMemberException.class,
                ()->bookService.addBook(bookDTO));

    }

    @Test
    @DisplayName("Test create book- Rainy Day")
    void testAddBookSunnyDay(){
        final var bookDTO = new BookDTO();
        final var category = new Category();
        Mockito.when(categoryRepository.findById(any())).thenReturn(Optional.of(category));

        bookDTO.setNumberOfPages(10);
        bookDTO.setCategories(List.of(1L));
        bookService.addBook(bookDTO);
        verify(bookRepository).save(any());
    }

    @Test
    @DisplayName("Test get by Id")
    void testGetById(){
        final var mockBook = new Book();
        Mockito.when(bookRepository.findById(any())).thenReturn(Optional.of(mockBook));
        final var response = bookService.getBookById(1L);
        Assert.assertEquals(response, mockBook);
    }

    @Test
    @DisplayName("Test delete ")
    void testDeleteById(){
        final var mockBook = new Book();
        Mockito.when(bookRepository.findById(1L)).thenReturn(Optional.of(mockBook));
        bookService.deleteBook(1L);
        verify(bookRepository).delete(mockBook);
    }
}
