package com.example.onlineshop.service.impl;

import com.example.onlineshop.dto.OrderDto;
import com.example.onlineshop.entity.Order;
import com.example.onlineshop.entity.Product;
import com.example.onlineshop.entity.User;
import com.example.onlineshop.exceptions.RecordNotFoundException;
import com.example.onlineshop.mapper.OrderMapper;
import com.example.onlineshop.repositories.OrderRepo;
import com.example.onlineshop.repositories.ProductRepo;
import com.example.onlineshop.repositories.UserRepo;
import com.example.onlineshop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final UserRepo userRepo;
    private final ProductRepo productRepo;
    private final OrderMapper orderMapper;
    private final OrderRepo orderRepo;
    @Override
    public OrderDto saveOrder(Long productId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String login = (String) authentication.getPrincipal();
        User user = userRepo.findByUsername(login)
                .orElseThrow(() -> new RuntimeException("Попробуйте перезайти в ваш аккаунт"));
        Order order = orderRepo.findById(user.getId())
                .orElse(new Order(user.getId(), user, null));
        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new RuntimeException("Not found"));
        List<Product> productList = order.getProductList();
        if (productList != null) {
            boolean productExists = false;
            for (Product searchProduct : productList) {
                if (searchProduct.getId().equals(productId)) {
                    productExists = true;
                    break;
                }
            }
            if (!productExists)
                productList.add(product);
        } else
            productList = Arrays.asList(product);
        order.setProductList(productList);

            Order orderSave = orderRepo.save(order);
            return orderMapper.toDTO(orderSave);

    }

    @Override
    public OrderDto updateOrder(OrderDto orderDto, long id) {
        Order order = this.orderRepo.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Заказа с таким id не существует!"));

        //TODO: сделать мап
        //OrderMapper.INSTANCE.update(order, orderDto);
        OrderMapper.INSTANCE.update(order, orderDto);


        order.setTotalPrice(getTotalPrice(order.getProductList()));

        try {
            Order orderSave = orderRepo.save(order);
            return OrderMapper.INSTANCE.toDTO(orderSave);
        } catch (RuntimeException e) {
            throw new RuntimeException("Не удалось обновить заказ в базе!", e);
        }
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

    //TODO: сделать метод
    private BigDecimal getTotalPrice(List<Product> productList){
        // надо высчитать
        BigDecimal total = BigDecimal.ZERO;
        for (Product product : productList){
            total = total.add(product.getPrice());
        }
        return total;
    }
}
