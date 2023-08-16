package com.example.onlineshop.service.impl;

import com.example.onlineshop.dto.OrderDto;
import com.example.onlineshop.entity.Order;
import com.example.onlineshop.entity.Product;
import com.example.onlineshop.exceptions.RecordNotFoundException;
import com.example.onlineshop.mapper.OrderMapper;
import com.example.onlineshop.repositories.OrderRepo;
import com.example.onlineshop.repositories.ProductRepo;
import com.example.onlineshop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderMapper orderMapper;
    private final OrderRepo orderRepo;
    private final ProductRepo productRepo;
    @Override
    public OrderDto saveOrder(OrderDto orderDto) {

        Order order = orderMapper.toEntity(orderDto);

        BigDecimal totalPrice = getTotalPrice(orderDto.getProducts());
        order.setTotalPrice(totalPrice);

        Order orderSave = orderRepo.save(order);
        return orderMapper.toDTO(orderSave);

    }

    @Override
    public OrderDto updateOrder(OrderDto orderDto, long id) {
        return null;
    }


//    @Override
//    public OrderDto updateOrder(OrderDto orderDto, long id) {
//        Order order = this.orderRepo.findById(id)
//                .orElseThrow(() -> new RecordNotFoundException("Заказа с таким id не существует!"));
//
//        //TODO: сделать мап
//        //OrderMapper.INSTANCE.update(order, orderDto);
//        OrderMapper.INSTANCE.update(order, orderDto);
//
//
//        order.setTotalPrice(getTotalPrice(order.getProductList()));
//
//        try {
//            Order orderSave = orderRepo.save(order);
//            return OrderMapper.INSTANCE.toDTO(orderSave);
//        } catch (RuntimeException e) {
//            throw new RuntimeException("Не удалось обновить заказ в базе!", e);
//        }
//    }

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
    private BigDecimal getTotalPrice(List<Long> productIds) {
        BigDecimal total = BigDecimal.ZERO;

        for (Long productId : productIds) {
            Product product = productRepo.findById(productId).orElse(null);
            if (product != null) {
                BigDecimal productPrice = product.getPrice();
                total = total.add(productPrice);
            }
        }

        return total;
    }

}
