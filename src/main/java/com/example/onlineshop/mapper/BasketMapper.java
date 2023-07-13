package com.example.onlineshop.mapper;

import com.example.onlineshop.dto.BasketDto;
import com.example.onlineshop.entity.Basket;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BasketMapper {
    BasketMapper INSTANCE = Mappers.getMapper(BasketMapper.class);
    Basket toEntity(BasketDto basketDto);
    BasketDto toDTO(Basket basket);
//    List<Basket> toEntityList(List<BasketDto> basketDtoList);
    List<BasketDto> toDTOList(List<Basket> basketList);
}
