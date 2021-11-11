package com.prisma.libraryapplication.repository;

import com.prisma.libraryapplication.entity.BookEntity;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<BookEntity, Long> {
}
