package com.hertz.assignment.librarysystem.controller;

import com.hertz.assignment.librarysystem.entity.Book;
import com.hertz.assignment.librarysystem.entity.BookDTO;
import com.hertz.assignment.librarysystem.entity.LoanBookDTO;
import com.hertz.assignment.librarysystem.service.MemberService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class MemberController {

    private final MemberService memberService;


    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/loan")
    public void loanBook(@RequestBody LoanBookDTO requestBody){
        memberService.loanBook(requestBody);
    }

    @PostMapping("/return-loaned")
    public void returnBookLoaned(@RequestBody LoanBookDTO requestBody){
        memberService.returnBook(requestBody);

    }
}
