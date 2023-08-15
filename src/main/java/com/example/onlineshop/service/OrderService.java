package com.example.onlineshop.service;

import com.example.onlineshop.dto.OrderDto;

import java.util.List;

public interface OrderService {
    OrderDto saveOrder(Long productId);
    OrderDto updateOrder(OrderDto orderDto, long id);
    List<OrderDto> findAllOrder();
    OrderDto getOrderById(Long id);
    void deleteOrder(Long id);
}
