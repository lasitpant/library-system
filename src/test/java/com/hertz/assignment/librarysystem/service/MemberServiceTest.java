package com.hertz.assignment.librarysystem.service;

import com.hertz.assignment.librarysystem.entity.Book;
import com.hertz.assignment.librarysystem.entity.BookLending;
import com.hertz.assignment.librarysystem.entity.LoanBookDTO;
import com.hertz.assignment.librarysystem.entity.User;
import com.hertz.assignment.librarysystem.exceptions.NotFoundException;
import com.hertz.assignment.librarysystem.repository.BookItemRepository;
import com.hertz.assignment.librarysystem.repository.BookRepository;
import com.hertz.assignment.librarysystem.repository.UserRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.Assert;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class MemberServiceTest {

    @Mock
    private BookItemRepository bookItemRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private BookRepository bookRepository;

    private MemberService memberService;

    @BeforeEach
    void setUp(){
        this.memberService = new MemberService(this.userRepository, this.bookItemRepository, this.bookRepository);
    }

    @Test
    @DisplayName("Test to throw Exception when user already loaned books at Max limit.")
    void testRainyDay(){
        LoanBookDTO loanBookDTO = new LoanBookDTO();
        loanBookDTO.setBookId(1L);
        loanBookDTO.setUserId(1L);

        final var mockUser = new User();
        final var mockBook = new Book();
        final var mockLending = new BookLending();
        final var mockLending1 = new BookLending();
        final var mockLending2 = new BookLending();


        Mockito.when(userRepository.findById(any())).thenReturn(Optional.of(mockUser));
        Mockito.when(bookRepository.findById(any())).thenReturn(Optional.of(mockBook));
        Mockito.when(bookItemRepository.findBookLendingByUser(any()))
                .thenReturn(List.of(mockLending, mockLending1, mockLending2, mockLending2));

        Assert.assertThrows(NotFoundException.class, ()->memberService.loanBook(loanBookDTO));

    }

    @Test
    @DisplayName("Sunny Day")
    void testLoan(){
        LoanBookDTO loanBookDTO = new LoanBookDTO();
        loanBookDTO.setBookId(1L);
        loanBookDTO.setUserId(1L);

        final var mockUser = new User();
        final var mockBook = new Book();
        final var mockLending = new BookLending();


        Mockito.when(userRepository.findById(any())).thenReturn(Optional.of(mockUser));
        Mockito.when(bookRepository.findById(any())).thenReturn(Optional.of(mockBook));
        Mockito.when(bookItemRepository.findBookLendingByUser(any()))
                .thenReturn(List.of(mockLending));
        Mockito.when(bookItemRepository.save(any())).thenReturn(mockLending);
        final var res = memberService.loanBook(loanBookDTO);
        Assert.assertEquals(res,mockLending);
    }
}
