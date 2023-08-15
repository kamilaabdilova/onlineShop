package com.example.onlineshop.service.impl;

import com.example.onlineshop.dto.BasketDto;
import com.example.onlineshop.entity.Basket;
import com.example.onlineshop.entity.Product;
import com.example.onlineshop.entity.User;
import com.example.onlineshop.mapper.BasketMapper;
import com.example.onlineshop.repositories.BasketRepo;
import com.example.onlineshop.repositories.ProductRepo;
import com.example.onlineshop.repositories.UserRepo;
import com.example.onlineshop.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BasketServiceImpl implements BasketService {
    private final BasketRepo basketRepo;
    private final UserRepo userRepo;
    private final ProductRepo productRepo;
    private final BasketMapper basketMapper;

    @Override
    public BasketDto addProduct(Long productId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String login = (String) authentication.getPrincipal();

        User user = userRepo.findByUsername(login)
                .orElseThrow(() -> new RuntimeException("Попробуйте перезайти в ваш аккаунт"));

        Basket basket = basketRepo.findById(user.getId())
                .orElse(new Basket(user.getId(), user, null));

        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new RuntimeException("Not found"));

        List<Product> productList = basket.getProductList();
        if (productList != null) {
            boolean productExists = false;
            for (Product searchProduct : productList) {
                if (searchProduct.getId().equals(productId)) {
                    productExists = true;
                    break;
                }
            }
            if (!productExists)
                productList.add(product);
        } else
            productList = Arrays.asList(product);
        basket.setProductList(productList);

        Basket savedBasket = basketRepo.save(basket);

        return basketMapper.toDTO(savedBasket);
    }

    @Override
    public BasketDto deleteProduct(Long productId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String login = (String) authentication.getPrincipal();

        User user = userRepo.findByUsername(login)
                .orElseThrow(() -> new RuntimeException("Попробуйте перезайти в ваш аккаунт"));

        Optional<Basket> oBasket = basketRepo.findById(user.getId());
        if (oBasket.isEmpty())
            return basketMapper.toDTO(new Basket(user.getId(), user, null));
        Basket basket = oBasket.get();


        Map<Long, Product> productMap = basket.getProductMap();

        if (productMap == null)
            return basketMapper.toDTO(basket);

        if (productMap.containsKey(productId))
            productMap.remove(productId);
        else
            return basketMapper.toDTO(basket);

        basket.setProductList(productMap.values().stream().collect(Collectors.toList()));
        Basket savedBasket = basketRepo.save(basket);

        return basketMapper.toDTO(savedBasket);
    }

    @Override
    public BasketDto getBasket() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String login = (String) authentication.getPrincipal();

        User user = userRepo.findByUsername(login)
                .orElseThrow(() -> new RuntimeException("Попробуйте перезайти в ваш аккаунт"));

        Basket basket = this.basketRepo.findById(user.getId())
                .orElse(new Basket(user.getId(), user, null));

        return basketMapper.toDTO(basket);
    }

    @Override
    public BasketDto clearBasket() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String login = (String) authentication.getPrincipal();

        User user = userRepo.findByUsername(login)
                .orElseThrow(() -> new RuntimeException("Попробуйте перезайти в ваш аккаунт"));

        Basket basket = this.basketRepo.findById(user.getId())
                .orElse(new Basket(user.getId(), user, null));

        basket.setProductList(null);
        Basket savedBasket = basketRepo.save(basket);

        return basketMapper.toDTO(basket);
    }
}
