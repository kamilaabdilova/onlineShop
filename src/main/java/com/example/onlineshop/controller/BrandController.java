package com.example.onlineshop.controller;


import com.example.onlineshop.dto.BrandDto;
import com.example.onlineshop.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/brand")
public class BrandController {
    private  final BrandService brandService;
    @PostMapping("/save")
    public BrandDto saveBrand(@RequestBody BrandDto brandDto){
        return brandService.saveBrand(brandDto);
    }
    @PostMapping("/update")
    public BrandDto updateBrand(@RequestBody BrandDto brandDto,  @PathVariable long id){

        return brandService.saveBrand(brandDto);
    }
    @GetMapping("/findAll")
    public List<BrandDto> findAll(){
        return brandService.findAllBrand();
    }
    @DeleteMapping("/delete")
    public void deleteBrand(@RequestParam Long id){
        brandService.deleteBrand(id);
    }


}
