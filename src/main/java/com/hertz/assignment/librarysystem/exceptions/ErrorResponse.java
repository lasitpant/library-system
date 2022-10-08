package com.hertz.assignment.librarysystem.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
public class ErrorResponse {
    private HttpStatus status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd hh:mm:ss")
    private LocalDateTime timeStamp;
    private String message;

    public ErrorResponse(HttpStatus status){
        this.status = status;
    }

    public ErrorResponse(HttpStatus status, String message){
        this();
        this.status = status;
        this.message = message;
    }

    public ErrorResponse(){
        this.timeStamp = LocalDateTime.now();
    }

    public ErrorResponse(HttpStatus status, String message, LocalDateTime timeStamp){
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }
}
