package com.example.onlineshop.service.impl;

import com.example.onlineshop.dto.OrderDto;
import com.example.onlineshop.entity.Order;
import com.example.onlineshop.exception.RecordNotFoundException;
import com.example.onlineshop.mapper.OrderMapper;
import com.example.onlineshop.repositories.OrderRepo;
import com.example.onlineshop.service.OrderService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepo orderRepo;
    @Override
    public OrderDto saveOrder(OrderDto orderDto) {
        Order order = OrderMapper.INSTANCE.toEntity(orderDto);
        try {
            Order orderSave = orderRepo.save(order);
            return OrderMapper.INSTANCE.toDTO(orderSave);
        } catch (RuntimeException e) {
            throw new RuntimeException("Не удалось сохранить заказ в базе!", e);
        }
    }

    @Override
    public OrderDto updateOrder(OrderDto orderDto, long id) {
        Order order = this.orderRepo.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Заказа с таким id не существует!"));
        order.setTotalPrice(orderDto.getTotalPrice());
        return OrderMapper.INSTANCE.toDTO(order);
    }

    @Override
    public List<OrderDto> findAllOrder() {
        return OrderMapper.INSTANCE.toDTOList(orderRepo.findAll());
    }

    @Override
    public OrderDto getOrderById(Long id) {
        Order order = this.orderRepo.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Заказа с таким id не существует!"));
        return OrderMapper.INSTANCE.toDTO(order);
    }

    @Override
    public void deleteOrder(Long id) {
        Order order = this.orderRepo.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Заказа с таким id не существует!"));
        orderRepo.deleteById(order.getId());
    }
}
