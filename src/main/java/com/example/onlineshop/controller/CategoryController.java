package com.example.onlineshop.controller;


import com.example.onlineshop.dto.CategoryDto;
import com.example.onlineshop.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;
    @PostMapping("/save")
    public CategoryDto saveCategory(@RequestBody CategoryDto categoryDto){
        return categoryService.saveCategory(categoryDto);
    }
    @PutMapping("/update")
    public CategoryDto updateCategory(@RequestBody CategoryDto categoryDto, @PathVariable long id){
        return categoryService.updateCategory(categoryDto, id);
    }
    @GetMapping("/findAll")
    public List<CategoryDto> findAll(){
        return categoryService.findAllCategory();
    }
    @DeleteMapping("/delete")
    public void deleteBasket(@RequestParam Long id){
        categoryService.deleteCategory(id);
    }
}
