package com.example.onlineshop.service;

import com.example.onlineshop.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto saveUser(UserDto userDto);
    UserDto updateUser(UserDto userDto, long id);
    UserDto getUserById(Long id);
    List<UserDto> findAllUser();
    void deleteUser(Long id);
}
