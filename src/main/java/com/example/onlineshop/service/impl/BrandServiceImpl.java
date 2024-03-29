package com.example.onlineshop.service.impl;

import com.example.onlineshop.dto.BrandDto;
import com.example.onlineshop.entity.Brand;
import com.example.onlineshop.exceptions.RecordNotFoundException;
import com.example.onlineshop.mapper.BrandMapper;
import com.example.onlineshop.repositories.BrandRepo;
import com.example.onlineshop.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class BrandServiceImpl implements BrandService {

    private final BrandRepo brandRepo;

    @Override
    public BrandDto saveBrand(BrandDto brandDto) {
        Brand brand = BrandMapper.INSTANCE.toEntity(brandDto);
        try {
            Brand brandSave = brandRepo.save(brand);
            return BrandMapper.INSTANCE.toDTO(brandSave);
        } catch (RuntimeException e) {
            throw new RuntimeException("Не удалось сохранить бренд в базе!", e);
        }
    }

    @Override
    public BrandDto updateBrand(BrandDto brandDto, long id) {
        Brand brand = this.brandRepo.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Бренда с таким id не существует!"));
        brand.setNameBrand(brandDto.getNameBrand());
        return BrandMapper.INSTANCE.toDTO(brand);
    }

    @Override
    public BrandDto getBrandById(Long id) {
        Brand brand = this.brandRepo.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Бренда с таким id не существует!"));
        return BrandMapper.INSTANCE.toDTO(brand);
    }

    @Override
    public List<BrandDto> findAllBrand() {
        return BrandMapper.INSTANCE.toDTOList(brandRepo.findAll());
    }

    @Override
    public void deleteBrand(Long id) {
        Brand brand = this.brandRepo.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Бренда с таким id не существует!"));
        brandRepo.deleteById(brand.getId());
    }
//    @Override
//    public List<Brand> findAllByNameBrand(String
//                                                  name){
//        return brandRepo.findAllByNameBrand(name);
//    }

}
