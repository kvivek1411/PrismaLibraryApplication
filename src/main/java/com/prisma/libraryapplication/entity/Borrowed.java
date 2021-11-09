package com.prisma.libraryapplication.entity;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import java.util.Date;
import java.util.Objects;

@Data
@Entity
public class Borrowed {
    
    @EmbeddedId
    private UserBookId id;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("bookId")
    private Book book;
    private Date borrowedFrom;
    private Date borrowedTo;
    
    public Borrowed() {
    }
    
    public Borrowed(User user, Book book) {
        this.user = user;
        this.book = book;
        this.id = new UserBookId(user.getId(), book.getId());
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        
        if (o == null || getClass() != o.getClass())
            return false;
    
        Borrowed that = (Borrowed) o;
        return Objects.equals(user, that.user) &&
                Objects.equals(book, that.book);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(user, book);
    }

}
