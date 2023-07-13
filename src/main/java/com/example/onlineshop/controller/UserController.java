package com.example.onlineshop.controller;


import com.example.onlineshop.dto.UserDto;
import com.example.onlineshop.service.UserService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.onlineshop.config.SwaggerConfig.BASKET;
@AllArgsConstructor
@Api(tags = BASKET)
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    @PostMapping("/save")
    public UserDto saveUser(@RequestBody UserDto userDto){
        return userService.saveUser(userDto);
    }
    @PutMapping("/update")
    public UserDto updateUser(@RequestBody UserDto userDto, @PathVariable long id){
        return userService.updateUser(userDto, id);
    }
    @GetMapping("/findAll")
    public List<UserDto> findAll(){
        return userService.findAllUser();
    }
    @DeleteMapping("/delete")
    public void deleteBasket(@RequestParam Long id){
        userService.deleteUser(id);
    }
}
