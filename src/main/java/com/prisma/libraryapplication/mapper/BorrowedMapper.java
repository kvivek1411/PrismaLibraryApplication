package com.prisma.libraryapplication.mapper;

import com.prisma.libraryapplication.dto.BorrowedDTO;
import com.prisma.libraryapplication.entity.BorrowedEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BorrowedMapper {
    
    BorrowedMapper INSTANCE = Mappers.getMapper(BorrowedMapper.class);
    
    BorrowedDTO entityToDTO(BorrowedEntity entity);
}
