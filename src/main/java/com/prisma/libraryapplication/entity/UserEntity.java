package com.prisma.libraryapplication.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "USER")
public class UserEntity {
    
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String firstName;
    private Date memberSince;
    private Date memberTill;
    private String gender;
    
}
