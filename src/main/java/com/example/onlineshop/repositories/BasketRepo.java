package com.example.onlineshop.repositories;

import com.example.onlineshop.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BasketRepo extends JpaRepository<Basket, Long> {
    Optional<Basket> findByUser(String user);


}
