package com.example.onlineshop.mapper;

import com.example.onlineshop.dto.CategoryDto;
import com.example.onlineshop.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
    Category toEntity(CategoryDto categoryDto);
    CategoryDto toDTO(Category category);
    List<CategoryDto> toDTOList(List<Category> categoryLIst);
}
