package com.example.onlineshop.service;

import com.example.onlineshop.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto saveCategory(CategoryDto categoryDto);
    CategoryDto updateCategory(CategoryDto categoryDto, long id);
    List<CategoryDto> findAllCategory();
    CategoryDto getCategoryById(Long id);
    void deleteCategory(Long id);
}
