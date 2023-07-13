package com.example.onlineshop.controller;


import com.example.onlineshop.dto.ProductDto;

import com.example.onlineshop.service.ProductService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.onlineshop.config.SwaggerConfig.PRODUCT;

@Api(tags = PRODUCT)
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
