package com.hertz.assignment.librarysystem.controller;


import com.hertz.assignment.librarysystem.entity.LoanBookDTO;
import com.hertz.assignment.librarysystem.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;

    private MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/loan")
    public ResponseEntity<?> loanBook(@RequestBody LoanBookDTO requestBody){
        return new ResponseEntity<>(memberService.loanBook(requestBody), HttpStatus.OK);
    }

    @PostMapping("/return")
    public ResponseEntity<?> returnBookLoaned(@RequestBody LoanBookDTO requestBody){
        memberService.returnBook(requestBody);
        return new ResponseEntity<>("book returned !",HttpStatus.NO_CONTENT);
    }

    @GetMapping("/books-loaned/{id}")
    public ResponseEntity<?> booksLoanedByUser(@PathVariable Long id){
        return new ResponseEntity<>(memberService.getBooksLoanedByUser(id),HttpStatus.OK);
    }
}
