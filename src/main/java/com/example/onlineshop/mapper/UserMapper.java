package com.example.onlineshop.mapper;

import com.example.onlineshop.dto.UserDto;
import com.example.onlineshop.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    User toEntity(UserDto userDto);
    UserDto toDTO(User user);
    List<UserDto> toDTOList(List<User> userList);
}
