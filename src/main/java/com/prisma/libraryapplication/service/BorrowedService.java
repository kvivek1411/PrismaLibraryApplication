package com.prisma.libraryapplication.service;

import com.prisma.libraryapplication.entity.BorrowedEntity;
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
    
    public List<BorrowedEntity> getAll() {
        return (List<BorrowedEntity>) borrowedRepository.findAll();
    }
}
