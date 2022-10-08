package com.hertz.assignment.librarysystem.exceptions;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<Object> exception(NotFoundException exception){
        return buildResponseEntity(new ErrorResponse(HttpStatus.NOT_FOUND,exception.getMessage()));
    }

    @ExceptionHandler(value = LibrarySystemMemberException.class)
    public ResponseEntity<Object> exception(LibrarySystemMemberException exception){
        return buildResponseEntity(new ErrorResponse(HttpStatus.NOT_FOUND,exception.getMessage()));
    }

    private ResponseEntity<Object> buildResponseEntity(ErrorResponse errorResponse){
        return new ResponseEntity<>(errorResponse, errorResponse.getStatus());
    }
}
