package com.prisma.libraryapplication.controller;

import com.prisma.libraryapplication.entity.User;
import com.prisma.libraryapplication.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@Api(tags = { "User" })
public class UserController {
    
    private final UserService userService;
    
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @GetMapping()
    @ApiOperation("Retrieve all users")
    public List<User> getAll() {
        return userService.getAll();
    }
}
