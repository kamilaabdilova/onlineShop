package com.example.onlineshop.controller;

import com.example.onlineshop.dto.UserDto;
import com.example.onlineshop.service.impl.UserServiceIml;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.onlineshop.config.SwaggerConfig.BASKET;
import static com.example.onlineshop.config.SwaggerConfig.USER;

@AllArgsConstructor
@Api(tags = USER)

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserServiceIml userServiceImpl;
    @PostMapping("/save")
    public UserDto saveUser(@RequestBody UserDto userDto){

        return userServiceImpl.saveUser(userDto);
    }
    @PutMapping("/update")
    public UserDto updateUser(@RequestBody UserDto userDto, @PathVariable long id){
        return userServiceImpl.updateUser(userDto, id);
    }
    @GetMapping("/findAll")
    public List<UserDto> findAll(){
        return userServiceImpl.findAllUser();
    }
    @DeleteMapping("/delete")
    public void deleteUser(@RequestParam Long id){
        userServiceImpl.deleteUser(id);

////кто угодно
//    @GetMapping("/unsecured")
//    public String unsecuredData(){
//        return "Unsecured Data";
//    }
////зарегист
//    @GetMapping("/secured")
//    public String securedData(){
//        return "Secured Data";
//    }
////админ
//    @GetMapping("/admin")
//    public String adminData(){
//        return "Admin Data";
//    }


}}
