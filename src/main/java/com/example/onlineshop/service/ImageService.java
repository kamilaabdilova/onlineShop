package com.example.onlineshop.service;

import com.example.onlineshop.dto.ImageDto;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    Long uploadPhoto( ImageDto imageDto);
}
