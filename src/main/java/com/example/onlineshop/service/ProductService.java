package com.example.onlineshop.service;

import com.example.onlineshop.dto.ProductDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    ProductDto saveProduct(ProductDto productDto, MultipartFile file);
    ProductDto updateProduct(ProductDto productDto, long id);
    List<ProductDto> findAllProduct();
    ProductDto getOrderById(Long id);
    void deleteProduct(Long id);
}
