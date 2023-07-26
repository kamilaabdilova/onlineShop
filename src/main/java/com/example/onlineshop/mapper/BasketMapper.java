package com.example.onlineshop.mapper;

import com.example.onlineshop.dto.BasketDto;
import com.example.onlineshop.dto.ProductDto;
import com.example.onlineshop.dto.ProductResponse;
import com.example.onlineshop.entity.Basket;
import com.example.onlineshop.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = ProductMapper.class, componentModel = "spring")
public interface BasketMapper {
    BasketMapper INSTANCE = Mappers.getMapper(BasketMapper.class);
    Basket toEntity(BasketDto basketDto);
    BasketDto toDTO(Basket basket);
    List<BasketDto> toDTOList(List<Basket> basketList);
}
