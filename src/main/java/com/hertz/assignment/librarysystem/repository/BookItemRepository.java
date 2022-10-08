package com.hertz.assignment.librarysystem.repository;


import com.hertz.assignment.librarysystem.entity.Book;
import com.hertz.assignment.librarysystem.entity.BooksLoaned;
import com.hertz.assignment.librarysystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookItemRepository extends JpaRepository<BooksLoaned, Long> {

    List<BooksLoaned> findBookLendingByUser(User user);
    BooksLoaned findBookLendingByUserAndBook(User user, Book book);

}
