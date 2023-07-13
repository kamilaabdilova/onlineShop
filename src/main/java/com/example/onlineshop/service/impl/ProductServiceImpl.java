package com.example.onlineshop.service.impl;

import com.example.onlineshop.dto.ProductDto;
import com.example.onlineshop.entity.Product;
import com.example.onlineshop.exception.RecordNotFoundException;
import com.example.onlineshop.mapper.ProductMapper;
import com.example.onlineshop.repositories.ProductRepo;
import com.example.onlineshop.service.ProductService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;
    @Override
    public ProductDto saveProduct(ProductDto productDto) {
        Product product = ProductMapper.INSTANCE.toEntity(productDto);
        try {
            Product productSave = productRepo.save(product);
            return ProductMapper.INSTANCE.toDTO(productSave);
        } catch (RuntimeException e) {
            throw new RuntimeException("Не удалось сохранить продукт в базе!", e);
        }
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto, long id) {
        Product product = this.productRepo.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Продукта с таким id не существует!"));
        return ProductMapper.INSTANCE.toDTO(product);
    }

    @Override
    public List<ProductDto> findAllProduct() {
        return ProductMapper.INSTANCE.toDTOList(productRepo.findAll());
    }

    @Override
    public ProductDto getOrderById(Long id) {
        Product product = this.productRepo.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Продукта с таким id не существует!"));
        return ProductMapper.INSTANCE.toDTO(product);
    }

    @Override
    public void deleteOrder(Long id) {
        Product product = this.productRepo.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Продукта с таким id не существует!"));
        productRepo.deleteById(product.getId());
    }
}
