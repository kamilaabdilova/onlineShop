package com.example.onlineshop.service;

import com.example.onlineshop.dto.ProductDto;
import com.example.onlineshop.dto.ProductResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    ProductDto saveProduct(ProductDto productDto);

    ProductDto updateProduct(ProductDto productDto, long id);
    List<ProductResponse> findAllProduct();
    ProductDto getProductById(Long id);
    void deleteProduct(Long id);
}
