package com.hertz.assignment.librarysystem.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookDTO {

    private String isbn;
    private String title;
    private String subject;
    private String language;
    private Integer numberOfPages;
    private List<Long> categories;
    private Long userKey;
}
