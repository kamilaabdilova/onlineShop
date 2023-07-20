package com.example.onlineshop.controller;

import com.example.onlineshop.dto.JwtRequest;
import com.example.onlineshop.dto.RegistrationUserDto;
import com.example.onlineshop.service.impl.AuthService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.onlineshop.config.SwaggerConfig.AUTH;

@Api(tags = AUTH)
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/auth")
    public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest authRequest) {
        return authService.createAuthToken(authRequest);
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/registration")
    public ResponseEntity<?> createNewUser(@RequestBody RegistrationUserDto registrationUserDto) {
        return authService.createNewUser(registrationUserDto);
    }
}
