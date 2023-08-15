package com.example.onlineshop.controller;


import com.example.onlineshop.dto.OrderDto;

import com.example.onlineshop.service.OrderService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.onlineshop.config.SwaggerConfig.ORDER;

@Api(tags = ORDER)
@AllArgsConstructor
@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;
    @PostMapping("/save")
    public OrderDto saveOrder(@RequestParam Long productId){
        return orderService.saveOrder(productId);
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
