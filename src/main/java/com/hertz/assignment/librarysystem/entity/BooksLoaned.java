package com.hertz.assignment.librarysystem.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "books_loaned")
public class BooksLoaned {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "borrowed_date")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date borrowed;

    @Column(name = "due_date")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dueDate;

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "book_id")
    private Book book;


}

