package com.example.onlineshop.controller;


import com.example.onlineshop.dto.OrderDto;

import com.example.onlineshop.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;
    @PostMapping("/save")
    public OrderDto saveOrder(@RequestBody OrderDto orderDto){
        return orderService.saveOrder(orderDto);
    }
    @PutMapping("/update")
    public OrderDto updateOrder(@RequestBody OrderDto orderDto, @PathVariable long id){
        return orderService.updateOrder(orderDto, id);
    }
    @GetMapping("/findAll")
    public List<OrderDto> findAll(){
        return orderService.findAllOrder();
    }
    @DeleteMapping("/delete")
    public void deleteBasket(@RequestParam Long id){
        orderService.deleteOrder(id);
    }
}
