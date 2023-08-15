package com.example.onlineshop.dto;

import com.example.onlineshop.entity.Product;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDto {
    Long id;
    String address;
    LocalDate date;
    String phone;
    Boolean payment;
    List<Product> productList;

}
