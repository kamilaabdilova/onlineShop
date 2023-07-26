package com.example.onlineshop.service;

import com.example.onlineshop.dto.BasketDto;

import java.util.List;

public interface BasketService {
    BasketDto addProduct(Long productId);
    BasketDto deleteProduct(Long productId);
    BasketDto clearBasket();
    BasketDto getBasket();
}
