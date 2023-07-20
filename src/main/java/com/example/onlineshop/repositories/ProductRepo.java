package com.example.onlineshop.repositories;

import com.example.onlineshop.entity.Order;
import com.example.onlineshop.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

}
