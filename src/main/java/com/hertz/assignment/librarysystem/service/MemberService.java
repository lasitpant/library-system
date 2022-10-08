package com.hertz.assignment.librarysystem.service;

import com.hertz.assignment.librarysystem.entity.*;
import com.hertz.assignment.librarysystem.exceptions.LibrarySystemMemberException;
import com.hertz.assignment.librarysystem.exceptions.NotFoundException;
import com.hertz.assignment.librarysystem.repository.BookItemRepository;
import com.hertz.assignment.librarysystem.repository.BookRepository;
import com.hertz.assignment.librarysystem.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Calendar;
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
        if (item==null) throw new NotFoundException("Data mismatch when unlinking !");
        changeBookStatus(book, true);
        bookItemRepository.delete(item);
    }


    //need to return for response
    public BooksLoaned loanBook(LoanBookDTO payload){

        final var user = userRepository.findById(payload.getUserId()).orElseThrow(()->new NotFoundException("user not found."));
        final var  book = bookRepository.findById(payload.getBookId()).orElseThrow(()-> new NotFoundException("book not found"));

        // check book availability
        if(!book.getAvailability()) throw new LibrarySystemMemberException("Book Already Loaned.");

        //check books the user already has loaned
        final var loanedBooks = bookItemRepository.findBookLendingByUser(user);

        //
//        if (loanedBooks.stream().filter(d->d.getId() == book.getId()).findFirst().isPresent()) throw new LibrarySystemMemberException("User already has this book loaned.");
        if (loanedBooks.size()>=3) throw new NotFoundException("User already has max number of books loaned!");

        final var response = bookItemRepository.save(bookLending(changeBookStatus(book, false), user));
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

    public static Date addDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }

    Book changeBookStatus(Book book, Boolean status){
        book.setAvailability(status);
        return bookRepository.save(book);

    }
}
