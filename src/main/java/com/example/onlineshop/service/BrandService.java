package com.example.onlineshop.service;

import com.example.onlineshop.dto.BrandDto;

import java.util.List;

public interface BrandService {
    BrandDto saveBrand(BrandDto brandDto);
    BrandDto updateBrand(BrandDto brandDto, long id);
    BrandDto getBrandById(Long id);
    List<BrandDto> findAllBrand();
    void deleteBrand(Long id);
}
