package com.prisma.libraryapplication.repository;

import com.prisma.libraryapplication.entity.BorrowedEntity;
import org.springframework.data.repository.CrudRepository;

public interface BorrowedRepository extends CrudRepository<BorrowedEntity, Long> {

}
