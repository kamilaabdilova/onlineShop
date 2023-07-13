package com.example.onlineshop.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.onlineshop.config.SwaggerConfig.BASKET;

@Api(tags = BASKET)
@RestController
@RequestMapping("/")
public class UserController {
}
