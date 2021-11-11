package com.prisma.libraryapplication.mapper;

import com.prisma.libraryapplication.dto.BorrowedDTO;
import com.prisma.libraryapplication.entity.BorrowedEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BorrowedMapper {
    
    BorrowedMapper INSTANCE = Mappers.getMapper(BorrowedMapper.class);
    
    List<BorrowedDTO> entitiesToDTOs(List<BorrowedEntity> entities);
    
    default BorrowedDTO map(BorrowedEntity entity) {
        BorrowedDTO dto = new BorrowedDTO();
        dto.setId(entity.getId());
        dto.setUser(entity.getUserEntity().getName() + ", " + entity.getUserEntity().getFirstName());
        dto.setBook(entity.getBookEntity().getTitle());
        dto.setBorrowedFrom(entity.getBorrowedFrom());
        dto.setBorrowedTo(entity.getBorrowedTo());
        return dto;
    }
}
