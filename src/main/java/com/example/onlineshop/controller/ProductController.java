package com.example.onlineshop.controller;


import com.example.onlineshop.dto.ProductDto;

import com.example.onlineshop.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    @PostMapping("/save")
    public ProductDto saveProduct(@RequestBody ProductDto productDto){
        return productService.saveProduct(productDto);
    }
    @PutMapping("/update")
    public ProductDto updateProduct(@RequestBody ProductDto productDto, @PathVariable long id){
        return productService.updateProduct(productDto, id);
    }
    @GetMapping("/findAll")
    public List<ProductDto> findAll(){
        return productService.findAllProduct();
    }
    @DeleteMapping("/delete")
    public void deleteProduct(@RequestParam Long id){
        productService.deleteProduct(id);
    }
}
