package com.hertz.assignment.librarysystem.exceptions;

import java.util.function.Supplier;

public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public NotFoundException(String message) {
        super(message);
    }
}
