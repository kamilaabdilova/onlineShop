package com.example.onlineshop.service.impl;

import com.example.onlineshop.dto.BasketDto;
import com.example.onlineshop.repositories.BasketRepo;
import com.example.onlineshop.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BasketServiceImpl implements BasketService {
    private final BasketRepo basketRepo;
    @Override
    public BasketDto save(BasketDto basketDto) {
        return basketDto;
    }
}
