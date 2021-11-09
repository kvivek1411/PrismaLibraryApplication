package com.prisma.libraryapplication.repository;

import com.prisma.libraryapplication.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
