package com.example.onlineshop.service.impl;

import com.example.onlineshop.dto.UserDto;
import com.example.onlineshop.entity.User;
import com.example.onlineshop.exception.RecordNotFoundException;
import com.example.onlineshop.mapper.UserMapper;
import com.example.onlineshop.repositories.UserRepo;
import com.example.onlineshop.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private  final UserRepo userRepo;
    @Override
    public UserDto saveUser(UserDto userDto) {
        User user = UserMapper.INSTANCE.toEntity(userDto);
        try {
            User userSave = userRepo.save(user);
            return UserMapper.INSTANCE.toDTO(userSave);
        } catch (RuntimeException e) {
            throw new RuntimeException("Не удалось сохранить пользователя в базе!", e);
        }
    }

    @Override
    public UserDto updateUser(UserDto userDto, long id) {
        User user  = this.userRepo.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Пользователя с таким id не существует!"));
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        return UserMapper.INSTANCE.toDTO(user);
    }

    @Override
    public UserDto getUserById(Long id) {
        User user  = this.userRepo.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Пользователя с таким id не существует!"));
        return UserMapper.INSTANCE.toDTO(user);
    }

    @Override
    public List<UserDto> findAllUser() {
        return UserMapper.INSTANCE.toDTOList(userRepo.findAll());
    }

    @Override
    public void deleteUser(Long id) {
        User user  = this.userRepo.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Пользователя с таким id не существует!"));
        userRepo.deleteById(user.getId());
    }
}
