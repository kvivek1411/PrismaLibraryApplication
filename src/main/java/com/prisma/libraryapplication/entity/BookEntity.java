package com.prisma.libraryapplication.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "BOOK")
public class BookEntity {
    
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String author;
    private String genre;
    private String publisher;
}
