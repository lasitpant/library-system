package com.hertz.assignment.librarysystem.service;

import com.hertz.assignment.librarysystem.entity.*;
import com.hertz.assignment.librarysystem.exceptions.LibrarySystemMemberException;
import com.hertz.assignment.librarysystem.exceptions.NotFoundException;
import com.hertz.assignment.librarysystem.repository.BookLendingRepository;
import com.hertz.assignment.librarysystem.repository.BookRepository;
import com.hertz.assignment.librarysystem.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class MemberService {
    private static final Integer MAX_LOAN_LIMIT = 3;
    private UserRepository userRepository;
    private BookLendingRepository bookLendingRepository;
    private BookRepository bookRepository;

    public MemberService(UserRepository userRepository,
                         BookLendingRepository bookLendingRepository,
                         BookRepository bookRepository){
        this.userRepository = userRepository;
        this.bookLendingRepository = bookLendingRepository;
        this.bookRepository = bookRepository;
    }

    public void returnBook(LoanBookDTO payload){
        final var user = userRepository.findById(payload.getUserId())
                .orElseThrow(()->new NotFoundException("User not found !"));
        final var  book = bookRepository.findById(payload.getBookId())
                .orElseThrow(()->new NotFoundException("Book not found !"));

        // unlink book from member
        final var item = bookLendingRepository.findBookLendingByUserAndBook(user, book);
        if (item==null) throw new LibrarySystemMemberException("Please check BookId and UserId. " +
                "No record of book loaned found.");
        changeBookStatus(book, true);
        bookLendingRepository.delete(item);
    }


    //need to return for response
    public BooksLoaned loanBook(LoanBookDTO payload){

        final var user = userRepository.findById(payload.getUserId()).orElseThrow(()->new NotFoundException("user not found."));
        final var  book = bookRepository.findById(payload.getBookId()).orElseThrow(()-> new NotFoundException("book not found"));

        // check book availability
        if(!book.getAvailability()) throw new LibrarySystemMemberException("Book Already Loaned.");

        //check books the user already has loaned
        final var loanedBooks = bookLendingRepository.findBookLendingByUser(user);

        //
//        if (loanedBooks.stream().filter(d->d.getId() == book.getId()).findFirst().isPresent()) throw new LibrarySystemMemberException("User already has this book loaned.");
        if (loanedBooks.size() >= MAX_LOAN_LIMIT) throw new NotFoundException("User already has max number of books loaned!");

        final var response = bookLendingRepository.save(bookLending(changeBookStatus(book, false), user));
        return response;
    }

    private BooksLoaned bookLending(Book book, User user){
        BooksLoaned bookLending = new BooksLoaned();
        bookLending.setBook(book);
        bookLending.setBorrowed(new Date());
        bookLending.setDueDate(addDays(new Date(),5));
        bookLending.setUser(user);

        return bookLending;
    }

    private static Date addDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }

    private Book changeBookStatus(Book book, Boolean status){
        book.setAvailability(status);
        return bookRepository.save(book);

    }
}
