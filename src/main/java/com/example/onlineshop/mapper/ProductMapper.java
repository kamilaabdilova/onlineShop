package com.example.onlineshop.mapper;

import com.example.onlineshop.dto.ProductDto;
import com.example.onlineshop.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    Product toEntity(ProductDto productDto);
    ProductDto toDTO(Product product);
    List<ProductDto> toDTOList(List<Product> productList);
}
