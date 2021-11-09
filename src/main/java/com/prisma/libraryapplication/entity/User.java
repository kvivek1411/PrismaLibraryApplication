package com.prisma.libraryapplication.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class User {
    
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String lastName;
    private Date memberSince;
    private Date memberTill;
    private String gender;
    
    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Borrowed> tags = new ArrayList<>();

}
