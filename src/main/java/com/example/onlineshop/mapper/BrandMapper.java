package com.example.onlineshop.mapper;

import com.example.onlineshop.dto.BrandDto;
import com.example.onlineshop.entity.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BrandMapper {
    BrandMapper INSTANCE = Mappers.getMapper(BrandMapper.class);
    Brand toEntity(BrandDto brandDto);
    BrandDto toDTO(Brand brand);
    List<BrandDto> toDTOList(List<Brand> brandList);
}
