package com.example.onlineshop.mapper;

import com.example.onlineshop.dto.OrderDto;
import com.example.onlineshop.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
    Order toEntity(OrderDto orderDto);
    OrderDto toDTO(Order order);
    List<OrderDto> toDTOList(List<Order> orderList);
}
