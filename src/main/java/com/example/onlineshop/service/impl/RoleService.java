package com.example.onlineshop.service.impl;

import com.example.onlineshop.entity.Role;
import com.example.onlineshop.repositories.RoleRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepo roleRepo;

    public Role getUserRole(){
        return roleRepo.findByName("ROLE_USER").get();
    }
}
