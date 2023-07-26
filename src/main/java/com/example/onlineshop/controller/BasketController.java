package com.example.onlineshop.controller;

import com.example.onlineshop.dto.BasketDto;
import com.example.onlineshop.service.BasketService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.onlineshop.config.SwaggerConfig.BASKET;

@Api(tags = BASKET)
@RequestMapping("/basket")
@RequiredArgsConstructor
@RestController
public class BasketController {
    private final BasketService basketService;

    @PostMapping("/addProductToBasket")
    public BasketDto addProduct(@RequestParam Long productId) {
        return basketService.addProduct(productId);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBasket(@PathVariable Long id) {
        basketService.deleteBasket(id);
    }
}
