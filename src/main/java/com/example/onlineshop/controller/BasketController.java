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

    @GetMapping("/get")
    public BasketDto getBasket() {
        return basketService.getBasket();
    }

    @PostMapping("/addProductToBasket")
    public BasketDto addProduct(@RequestParam Long productId) {
        return basketService.addProduct(productId);
    }

    @PostMapping("/deleteProductInBasket")
    public BasketDto deleteProduct(@RequestParam Long productId) {
        return basketService.deleteProduct(productId);
    }

    @DeleteMapping("/clear")
    public BasketDto deleteBasket() {
        return basketService.clearBasket();
    }
}
