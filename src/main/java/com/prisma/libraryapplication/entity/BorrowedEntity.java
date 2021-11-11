package com.prisma.libraryapplication.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "BORROWED")
public class BorrowedEntity {
    
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private UserEntity userEntity;
    @ManyToOne
    @JoinColumn(name = "bookId", referencedColumnName = "id")
    private BookEntity bookEntity;
    private Date borrowedFrom;
    private Date borrowedTo;
    
}
