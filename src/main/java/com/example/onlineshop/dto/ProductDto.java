package com.example.onlineshop.dto;

import com.example.onlineshop.entity.Image;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDto {
    Long id;
    Double price;
    Long imageId;
    String description;
    Long statusId;
    Long categoryId;
    Long brandId;
}
