package com.example.onlineshop.service.impl;

import com.example.onlineshop.dto.CategoryDto;
import com.example.onlineshop.entity.Category;
import com.example.onlineshop.exception.RecordNotFoundException;
import com.example.onlineshop.mapper.CategoryMapper;
import com.example.onlineshop.repositories.CategoryRepo;
import com.example.onlineshop.service.CategoryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class CategoryImpl implements CategoryService {
    private final CategoryRepo categoryRepo;
    @Override
    public CategoryDto saveCategory(CategoryDto categoryDto) {
        Category category = CategoryMapper.INSTANCE.toEntity(categoryDto);
        try {
            Category categorySave = categoryRepo.save(category);
            return CategoryMapper.INSTANCE.toDTO(categorySave);
        } catch (RuntimeException e) {
            throw new RuntimeException("Не удалось сохранить категорию в базе!", e);
        }
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, long id) {
        Category category = this.categoryRepo.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Категории с таким id не существует!"));
        category.setNameCategory(categoryDto.getNameCategory());
        return CategoryMapper.INSTANCE.toDTO(category);
    }

    @Override
    public List<CategoryDto> findAllCategory() {
        return CategoryMapper.INSTANCE.toDTOList(categoryRepo.findAll());
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        Category category = this.categoryRepo.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Категории с таким id не существует!"));
        return CategoryMapper.INSTANCE.toDTO(category);
    }

    @Override
    public void deleteCategory(Long id) {
        Category category = this.categoryRepo.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Категории с таким id не существует!"));
        categoryRepo.deleteById(category.getId());
    }
}
