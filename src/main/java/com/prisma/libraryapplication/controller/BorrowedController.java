package com.prisma.libraryapplication.controller;

import com.prisma.libraryapplication.service.BorrowedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/borrowed")
@RequiredArgsConstructor
public class BorrowedController {
    
    private final BorrowedService borrowedService;
    
    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(borrowedService.getAll());
    }
    
    @GetMapping("users")
    public ResponseEntity<?> getAllBorrowedUsers() {
        return ResponseEntity.ok(borrowedService.getAllBorrowedUsers());
    }
}
