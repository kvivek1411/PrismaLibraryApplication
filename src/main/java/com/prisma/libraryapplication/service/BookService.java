package com.prisma.libraryapplication.service;

import com.prisma.libraryapplication.dto.BookDTO;
import com.prisma.libraryapplication.entity.BookEntity;
import com.prisma.libraryapplication.mapper.BookMapper;
import com.prisma.libraryapplication.repository.BookRepository;
import com.prisma.libraryapplication.repository.BorrowedRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {
    
    private final BookRepository bookRepository;
    private final BorrowedRepository borrowedRepository;
    private static final BookMapper bookMapper = BookMapper.INSTANCE;
    
    public List<BookDTO> getAll() {
        return bookMapper.entitiesToDTOs((List<BookEntity>) bookRepository.findAll());
    }
    
    public List<BookDTO> getAllNonBorrowedBooks() {
        List<BookEntity> books = borrowedRepository.getAllNonBorrowedBooks();
        return bookMapper.entitiesToDTOs(books);
    }
}
