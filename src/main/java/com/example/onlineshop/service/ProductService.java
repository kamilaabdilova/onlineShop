package com.example.onlineshop.service;

import com.example.onlineshop.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto saveProduct(ProductDto productDto);
    ProductDto updateProduct(ProductDto productDto, long id);
    List<ProductDto> findAllProduct();
    ProductDto getOrderById(Long id);
    void deleteOrder(Long id);
}
