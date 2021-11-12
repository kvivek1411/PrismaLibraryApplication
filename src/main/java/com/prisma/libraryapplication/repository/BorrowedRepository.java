package com.prisma.libraryapplication.repository;

import com.prisma.libraryapplication.entity.BookEntity;
import com.prisma.libraryapplication.entity.BorrowedEntity;
import com.prisma.libraryapplication.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BorrowedRepository extends CrudRepository<BorrowedEntity, Long> {
    
    @Query("SELECT DISTINCT b.userEntity FROM BorrowedEntity b")
    List<UserEntity> findDistinctUsers();
    
    @Query("SELECT bk FROM BookEntity bk LEFT JOIN BorrowedEntity bw on bk.id = bw.bookEntity.id where bw.bookEntity.id is null")
    List<BookEntity> getAllNonBorrowedBooks();
    
    List<BorrowedEntity> findByBorrowedToIsNull();
}
