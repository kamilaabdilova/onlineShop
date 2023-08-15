package com.example.onlineshop.mapper;

import com.example.onlineshop.dto.ProductDto;
import com.example.onlineshop.dto.ProductResponse;
import com.example.onlineshop.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(target = "status",
            expression = "java(productDto.getStatusId() == null ?" +
                    "null :" +
                    "new com.example.onlineshop.entity.Status(productDto.getStatusId(),null))")
    @Mapping(target = "category",
            expression = "java(productDto.getCategoryId() == null ?" +
                    "null :" +
                    "new com.example.onlineshop.entity.Category(productDto.getCategoryId(),null))")
    @Mapping(target = "image",
            expression = "java(productDto.getImageId() == null ?" +
                    "null :" +
                    "new com.example.onlineshop.entity.Image(productDto.getImageId(),null,null,null))")
    Product toEntity(ProductDto productDto);

    @Mapping(target = "categoryId", source = "category.id")
    @Mapping(target = "statusId", source = "status.id")
    @Mapping(target = "imageId", source = "image.id")
    ProductDto toDTO(Product product);

    List<ProductDto> toDTOList(List<Product> productList);

    ProductResponse toResponse(Product product);

    List<ProductResponse> toResponseList(List<Product> productList);

    @Mapping(target = "status",
            expression = "java(productDto.getStatusId() == null ?" +
                    "product.getStatus() :" +
                    "new com.example.onlineshop.entity.Status(productDto.getStatusId(),null))")
    @Mapping(target = "image",
            expression = "java(productDto.getImageId() == null ?" +
                    "product.getImage() :" +
                    "new com.example.onlineshop.entity.Image(productDto.getImageId(),null,null,null))")
    void update(@MappingTarget Product product, ProductDto productDto);

}
