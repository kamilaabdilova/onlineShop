package com.example.onlineshop.service.impl;

import com.example.onlineshop.dto.ProductDto;
import com.example.onlineshop.dto.ProductResponse;
import com.example.onlineshop.entity.Product;
import com.example.onlineshop.exceptions.RecordNotFoundException;
import com.example.onlineshop.mapper.ProductMapper;
import com.example.onlineshop.repositories.ProductRepo;
import com.example.onlineshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;

    @Override
    public ProductDto saveProduct(ProductDto productDto) {

        Product product = ProductMapper.INSTANCE.toEntity(productDto);

        try {
            Product productSave = productRepo.save(product);
            return ProductMapper.INSTANCE.toDTO(productSave);
        } catch (RuntimeException e) {
            throw new RuntimeException("Не удалось сохранить продукт в базе!", e);
        }
    }


    private String fileDownload(MultipartFile file) {
        try {
            File path = new File("C:\\" + file.getOriginalFilename());
            path.createNewFile();
            FileOutputStream output = new FileOutputStream(path);
            output.write(file.getBytes());
            output.close();
            return path.getAbsolutePath();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto, long id) {
        Product product = this.productRepo.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Продукта с таким id не существует!"));

        ProductMapper.INSTANCE.update(product, productDto);

        try {
            Product productSave = productRepo.save(product);
            return ProductMapper.INSTANCE.toDTO(productSave);
        } catch (RuntimeException e) {
            throw new RuntimeException("Не удалось обновить продукт в базе!", e);
        }
    }

    @Override
    public List<ProductResponse> findAllProduct() {
        return ProductMapper.INSTANCE.toResponseList(productRepo.findAll());
    }

    @Override
    public ProductDto getProductById(Long id) {
        Product product = this.productRepo.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Продукта с таким id не существует!"));
        return ProductMapper.INSTANCE.toDTO(product);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = this.productRepo.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Продукта с таким id не существует!"));
        productRepo.deleteById(product.getId());
    }
}
