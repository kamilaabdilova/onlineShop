package com.example.onlineshop.service.impl;

import com.example.onlineshop.dto.BasketDto;
import com.example.onlineshop.entity.Basket;
import com.example.onlineshop.exceptions.RecordNotFoundException;
import com.example.onlineshop.mapper.BasketMapper;
import com.example.onlineshop.repositories.BasketRepo;
import com.example.onlineshop.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BasketServiceImpl implements BasketService {
    private final BasketRepo basketRepo;

    @Override
    public BasketDto saveBasket(BasketDto basketDto) {
        Basket basket = BasketMapper.INSTANCE.toEntity(basketDto);
        try {
            Basket basketSave = basketRepo.save(basket);
            return BasketMapper.INSTANCE.toDTO(basketSave);
        } catch (RuntimeException e) {
            throw new RuntimeException("Не удалось сохранить корзину в базе!", e);
        }
    }

    @Override
    public BasketDto updateBasket(BasketDto basketDto, long id) {
        Basket basket = this.basketRepo.findById(id)
                        .orElseThrow(() -> new RecordNotFoundException("Корзины с таким id не существует!"));
        basket.setUser(basketDto.getUser());
        return BasketMapper.INSTANCE.toDTO(basket);
    }

    @Override
    public BasketDto getBasketById(Long id) {
        Basket basket = this.basketRepo.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Корзины с таким id не существует!"));
        return BasketMapper.INSTANCE.toDTO(basket);
    }

    @Override
    public List<BasketDto> findAllBasket() {
        return BasketMapper.INSTANCE.toDTOList(basketRepo.findAll());
    }

    @Override
    public void deleteBasket(Long id) {
        Basket basket = this.basketRepo.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Корзины с таким id не существует!"));
        basketRepo.deleteById(basket.getId());
    }

}
