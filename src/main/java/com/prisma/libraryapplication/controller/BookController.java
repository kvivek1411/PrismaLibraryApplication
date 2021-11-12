package com.prisma.libraryapplication.controller;

import com.prisma.libraryapplication.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {
    
    private final BookService bookService;
    
    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(bookService.getAll());
    }
    
    @GetMapping("nonBorrowed")
    public ResponseEntity<?> getAllBorrowedUsers() {
        return ResponseEntity.ok(bookService.getAllNonBorrowedBooks());
    }
}
