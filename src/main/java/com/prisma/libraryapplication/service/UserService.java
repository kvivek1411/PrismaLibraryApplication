package com.prisma.libraryapplication.service;

import com.prisma.libraryapplication.dto.UserDTO;
import com.prisma.libraryapplication.entity.BorrowedEntity;
import com.prisma.libraryapplication.entity.UserEntity;
import com.prisma.libraryapplication.mapper.UserMapper;
import com.prisma.libraryapplication.repository.BorrowedRepository;
import com.prisma.libraryapplication.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    
    private final UserRepository userRepository;
    private final BorrowedRepository borrowedRepository;
    private static final UserMapper userMapper = UserMapper.INSTANCE;
    
    public List<UserDTO> getAll() {
        return userMapper.entitiesToDTOs((List<UserEntity>) userRepository.findAll());
    }
    
    public List<UserDTO> getAllActiveNonBorrowedUsers() {
        List<UserEntity> activeUsers = userRepository.findByMemberTillIsNull();
        List<BorrowedEntity> borrowed = borrowedRepository.findByBorrowedToIsNull();
        List<UserEntity> borrowedUsers = borrowed.stream().map(BorrowedEntity::getUserEntity).distinct().collect(Collectors.toList());
        activeUsers.removeAll(borrowedUsers);
        return userMapper.entitiesToDTOs(activeUsers);
    }
}
