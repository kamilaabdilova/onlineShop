package com.example.onlineshop.controller;

import com.example.onlineshop.dto.BrandDto;
import com.example.onlineshop.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/brand")
public class BrandController {
    private  final BrandService brandService;
    @PostMapping("/save")
    public BrandDto saveBrand(@RequestBody BrandDto brandDto){
        return brandService.saveBrand(brandDto);
    }
}
