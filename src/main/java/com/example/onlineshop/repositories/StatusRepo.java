package com.example.onlineshop.repositories;

import com.example.onlineshop.entity.Status;
import com.example.onlineshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatusRepo extends JpaRepository<Status, Long> {
}
