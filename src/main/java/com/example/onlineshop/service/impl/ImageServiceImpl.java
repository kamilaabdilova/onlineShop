package com.example.onlineshop.service.impl;

import com.example.onlineshop.dto.ImageDto;
import com.example.onlineshop.entity.Image;
import com.example.onlineshop.mapper.ImageMapper;
import com.example.onlineshop.repositories.ImageRepo;
import com.example.onlineshop.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

//@NoArgsConstructor
@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    private final ImageRepo imageRepo;
    private final ImageMapper imageMapper;

    @Override
    public Long uploadPhoto(ImageDto imageDto) {

        Image image = imageMapper.toEntity(imageDto);

        Long id = imageRepo.save(image).getId();

        return id;



//        // Specify the directory where the image will be saved
//        String directoryPath = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "foto";
//
//        // Create a File object with the specified path and filename
//        File file = new File(directoryPath + File.separator + imageDto.getImageName());
//
//        // Create the parent directories if they don't exist
//        File parentDir = file.getParentFile();
//        if (!parentDir.exists()) {
//            parentDir.mkdirs();
//        }

        // Write the byte array data to the file
//        try (FileOutputStream fos = new FileOutputStream(file)) {
//            fos.write(data);
//
////            uploadPhoto.setImage(imageDto.getImageName());
////            productRepo.save(uploadPhoto);
//
//            return imageDto.getImageName();
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.println("Failed to save file: " + e.getMessage());
//            return e.getMessage();
//        }
    }
}
//        String base64String = imageDto.getImageData().split(",")[1];
//        byte[] data = Base64.getDecoder().decode(base64String);
//        // Create a File object with the specified path
//        String filePath = "src/main/resources/foto";
//        File file = new File(imageDto.getImageName() + imageDto.getImageExtension());
//
//        // Create the parent directories if they don't exist
//        File parentDir = file.getParentFile();
//        if (!parentDir.exists()) {
//            parentDir.mkdirs();
//        }
//
//        // Write the byte array data to the file
//        try (FileOutputStream fos = new FileOutputStream(file)) {
//            fos.write(data);
//            return imageDto.getImageName() + imageDto.getImageExtension();
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.println("Failed to save file: " + e.getMessage());
//            return e.getMessage();
//        }
//    }

