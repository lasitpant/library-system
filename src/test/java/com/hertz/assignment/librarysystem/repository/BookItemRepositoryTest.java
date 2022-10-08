//package com.hertz.assignment.librarysystem.repository;
//
//import com.hertz.assignment.librarysystem.entity.Book;
//import com.hertz.assignment.librarysystem.entity.BookLending;
//import com.hertz.assignment.librarysystem.entity.Category;
//import com.hertz.assignment.librarysystem.entity.User;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//import java.util.Set;
//
//@SpringBootTest
//public class BookItemRepositoryTest {
//
//    @Autowired
//    private BookItemRepository bookItemRepository;
//
//    @Test
//    void isBookLoaned(){
//        final var category = new Category();
//        category.setCategory("Fiction");
//        category.setId(1L);
//
//        final var book = new Book();
//        book.setAvailability(true);
//        book.setNumberOfPages(122);
//        book.setSubject("Test Subject");
//        book.setLanguage("English");
//        book.setTitle("Test Title");
//        book.setISBN("123-88819");
//        book.setCategories(Set.of(category));
//
//        final var user = new User();
//        user.
//        BookLending bookLending = new BookLending();
//        bookLending.setBook(book);
//    }
//}
