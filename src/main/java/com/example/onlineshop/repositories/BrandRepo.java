package com.example.onlineshop.repositories;

import com.example.onlineshop.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepo extends JpaRepository<Brand, Long> {
List<Brand> findAllByNameBrand(String name);

}
