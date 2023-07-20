package com.example.onlineshop.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.annotation.Validated;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegistrationUserDto {
     String username;
     String password;
     String confirmPassword;
     String email;
}
