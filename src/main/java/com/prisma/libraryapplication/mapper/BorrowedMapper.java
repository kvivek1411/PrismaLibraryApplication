package com.prisma.libraryapplication.mapper;

import com.prisma.libraryapplication.dto.BorrowedDTO;
import com.prisma.libraryapplication.entity.BorrowedEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BorrowedMapper {
    
    BorrowedMapper INSTANCE = Mappers.getMapper(BorrowedMapper.class);
    
    List<BorrowedDTO> entitiesToDTOs(List<BorrowedEntity> entities);
}
