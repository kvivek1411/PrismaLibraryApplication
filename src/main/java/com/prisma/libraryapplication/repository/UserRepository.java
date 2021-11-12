package com.prisma.libraryapplication.repository;

import com.prisma.libraryapplication.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    
    List<UserEntity> findByMemberTillIsNull();
}
