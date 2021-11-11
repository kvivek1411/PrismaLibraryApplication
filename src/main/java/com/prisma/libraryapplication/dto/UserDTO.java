package com.prisma.libraryapplication.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserDTO {
    
    private Long id;
    private String name;
    private String firstName;
    private Date memberSince;
    private Date memberTill;
    private String gender;
}
