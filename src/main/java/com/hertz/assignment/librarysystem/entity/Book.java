package com.hertz.assignment.librarysystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "book")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "isbn", length = 150, unique = true)
    private String ISBN;

    @Column(name = "title", length = 200, nullable = false)
    private String title;

    @Column(name = "subject", length = 100, nullable = false)
    private String subject;

    @Column(name = "publisher", length = 100, nullable = false)
    private String publisher;

    @Column(name = "language", length = 50, nullable = false)
    private String language;

    @Column(name = "pages", nullable = false)
    private int numberOfPages;

    @ManyToMany
    @JoinColumn(name = "category_id")
    private Set<Category> categories = new HashSet<>();

    @Column(name = "availability" ,nullable = false)
    private Boolean availability;
}
