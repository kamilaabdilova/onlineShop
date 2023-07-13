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
    @PostMapping("/save")
    public BasketDto saveBasket(@RequestBody BasketDto basketDto){
        return basketService.saveBasket(basketDto);
    }
    @PutMapping("/update")
    public BasketDto updateBasket(@RequestBody BasketDto basketDto, @PathVariable long id){
        return basketService.updateBasket(basketDto, id);
    }
    @GetMapping("/findAll")
    public List<BasketDto> findAll(){
        return basketService.findAllBasket();
    }
    @DeleteMapping("/delete")
    public void deleteBasket(@RequestParam Long id){
        basketService.deleteBasket(id);
    }
}
