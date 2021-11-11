package com.prisma.libraryapplication.service;

import com.prisma.libraryapplication.entity.UserEntity;
import com.prisma.libraryapplication.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    
    private final UserRepository userRepository;
    
    public List<UserEntity> getAll() {
        return (List<UserEntity>) userRepository.findAll();
    }
}
