package com.prisma.libraryapplication.service;

import com.prisma.libraryapplication.dto.BorrowedDTO;
import com.prisma.libraryapplication.dto.UserDTO;
import com.prisma.libraryapplication.entity.BorrowedEntity;
import com.prisma.libraryapplication.mapper.BorrowedMapper;
import com.prisma.libraryapplication.mapper.UserMapper;
import com.prisma.libraryapplication.repository.BorrowedRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BorrowedService {
    
    private final BorrowedRepository borrowedRepository;
    private static final BorrowedMapper borrowedMapper = BorrowedMapper.INSTANCE;
    private static final UserMapper userMapper = UserMapper.INSTANCE;
    
    public List<BorrowedDTO> getAll() {
        return borrowedMapper.entitiesToDTOs((List<BorrowedEntity>) borrowedRepository.findAll());
    }
    
    public List<UserDTO> getAllBorrowedUsers() {
        return userMapper.entitiesToDTOs(borrowedRepository.findDistinctUsers());
    }
}
