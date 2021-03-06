package com.prisma.libraryapplication.controller;

import com.prisma.libraryapplication.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    
    private final UserService userService;
    
    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }
    
    @GetMapping("active/nonBorrowed")
    public ResponseEntity<?> getAllActiveNonBorrowedUsers() {
        return ResponseEntity.ok(userService.getAllActiveNonBorrowedUsers());
    }
}
