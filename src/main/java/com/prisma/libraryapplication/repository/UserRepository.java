package com.prisma.libraryapplication.repository;

import com.prisma.libraryapplication.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

}
