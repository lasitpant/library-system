package com.hertz.assignment.librarysystem.service;

import com.hertz.assignment.librarysystem.entity.*;
import com.hertz.assignment.librarysystem.exceptions.NotFoundException;
import com.hertz.assignment.librarysystem.repository.BookItemRepository;
import com.hertz.assignment.librarysystem.repository.BookRepository;
import com.hertz.assignment.librarysystem.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MemberService {

    private UserRepository userRepository;

    private BookItemRepository bookItemRepository;
    private BookRepository bookRepository;

    public MemberService(UserRepository userRepository,
                         BookItemRepository bookItemRepository,
                         BookRepository bookRepository){
        this.userRepository = userRepository;
        this.bookItemRepository = bookItemRepository;
        this.bookRepository = bookRepository;
    }

    public void returnBook(LoanBookDTO payload){
        final var user = userRepository.getReferenceById(payload.getUserId());
        final var  book = bookRepository.getReferenceById(payload.getBookId());
        // unlink book from member

        final var item = bookItemRepository.findBookLendingByUserAndBook(user, book);
        if (item != null){
            System.out.println("DELETE");
//            bookItemRepository.delete(item);
        }

//        bookItemRepository.delete(bookLending);

    }


    //need to return for response
    public void loanBook(LoanBookDTO payload){

        final var user = userRepository.getReferenceById(payload.getUserId());
        final var  book = bookRepository.getReferenceById(payload.getBookId());

        //check books the user already has loaned
        final var loanedBooks = bookItemRepository.findBookLendingByUser(user);
        if (loanedBooks.size()>3) throw new NotFoundException("User already has max number of books loaned!");
        bookItemRepository.save(bookLending(book, user));
    }

    private BookLending bookLending(Book book, User user){
        BookLending bookLending = new BookLending();
        bookLending.setBook(book);
        bookLending.setBorrowed(new Date());
        bookLending.setDueDate(new Date());
        bookLending.setUser(user);

        return bookLending;
    }

}
