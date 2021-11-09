package com.prisma.libraryapplication.repository;

import com.prisma.libraryapplication.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
