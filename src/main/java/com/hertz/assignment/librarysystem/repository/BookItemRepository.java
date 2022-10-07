package com.hertz.assignment.librarysystem.repository;


import com.hertz.assignment.librarysystem.entity.Book;
import com.hertz.assignment.librarysystem.entity.BookLending;
import com.hertz.assignment.librarysystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookItemRepository extends JpaRepository<BookLending, Long> {

    List<BookLending> findBookLendingByUser(User user);
    BookLending findBookLendingByUserAndBook(User user, Book book);

}
