package com.prisma.libraryapplication.mapper;

import com.prisma.libraryapplication.dto.UserDTO;
import com.prisma.libraryapplication.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    
    List<UserDTO> entitiesToDTOs(List<UserEntity> entities);
}
