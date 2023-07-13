package com.example.onlineshop.service;

import com.example.onlineshop.dto.BasketDto;

import java.util.List;

public interface BasketService {
    BasketDto saveBasket(BasketDto basketDto);
    BasketDto updateBasket(BasketDto basketDto, long id);
    BasketDto getBasketById(Long id);
    List<BasketDto> findAllBasket();
    void deleteBasket(Long id);
}
