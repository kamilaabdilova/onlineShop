package com.example.onlineshop.dto;

import com.example.onlineshop.entity.Category;
import com.example.onlineshop.entity.Image;
import com.example.onlineshop.entity.Status;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductResponse {
    Long id;
    Double price;
    Image image;
    String description;
    Status status;
    Category category;
}
