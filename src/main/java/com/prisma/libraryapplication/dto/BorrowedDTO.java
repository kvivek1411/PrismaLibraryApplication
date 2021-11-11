package com.prisma.libraryapplication.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BorrowedDTO {
    
    private Long id;
    private String user;
    private String book;
    private Date borrowedFrom;
    private Date borrowedTo;
}
