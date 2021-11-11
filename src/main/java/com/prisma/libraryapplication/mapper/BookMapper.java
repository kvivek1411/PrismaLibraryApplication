package com.prisma.libraryapplication.mapper;

import com.prisma.libraryapplication.dto.BookDTO;
import com.prisma.libraryapplication.entity.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {
    
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);
    
    List<BookDTO> entitiesToDTOs(List<BookEntity> entities);
}
