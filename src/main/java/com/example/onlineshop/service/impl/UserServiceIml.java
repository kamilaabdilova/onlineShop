package com.example.onlineshop.service.impl;

import com.example.onlineshop.dto.RegistrationUserDto;
import com.example.onlineshop.dto.UserDto;
import com.example.onlineshop.entity.User;
import com.example.onlineshop.exception.RecordNotFoundException;
import com.example.onlineshop.mapper.UserMapper;
import com.example.onlineshop.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class UserServiceIml implements UserDetailsService {
    private UserRepo userRepository;
    private RoleService roleService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setUserRepository(UserRepo userRepository) {
        this.userRepository = userRepository;
    }
    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }
    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(
                String.format("Пользователь '%s' не найден", username)
        ));
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList())
        );
    }
    public User createNewUser(RegistrationUserDto registrationUserDto){
        User user = new User();
        user.setUsername(registrationUserDto.getUsername());
        user.setEmail(registrationUserDto.getEmail());
        user.setPassword(passwordEncoder.encode(registrationUserDto.getPassword()));
        user.setRoles(List.of(roleService.getUserRole()));
        return userRepository.save(user);
    }

    public UserDto saveUser(UserDto userDto) {
        User user = UserMapper.INSTANCE.toEntity(userDto);
        try {
            User userSave = userRepository.save(user);
            return UserMapper.INSTANCE.toDTO(userSave);
        } catch (RuntimeException e) {
            throw new RuntimeException("Не удалось сохранить пользователя в базе!", e);
        }
    }

    public UserDto updateUser(UserDto userDto, long id) {
        User user  = this.userRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Пользователя с таким id не существует!"));
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        return UserMapper.INSTANCE.toDTO(user);
    }


    public UserDto getUserById(Long id) {
        User user  = this.userRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Пользователя с таким id не существует!"));
        return UserMapper.INSTANCE.toDTO(user);
    }

    public List<UserDto> findAllUser() {
        return UserMapper.INSTANCE.toDTOList(userRepository.findAll());
    }

    public void deleteUser(Long id) {
        User user  = this.userRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Пользователя с таким id не существует!"));
        userRepository.deleteById(user.getId());
    }


}

