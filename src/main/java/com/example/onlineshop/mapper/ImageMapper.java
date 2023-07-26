package com.example.onlineshop.mapper;

import com.example.onlineshop.dto.ImageDto;
import com.example.onlineshop.entity.Image;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Base64;

@Mapper(componentModel = "spring")
public interface ImageMapper {
    ImageMapper INSTANCE = Mappers.getMapper(ImageMapper.class);

    @Mapping(target = "name", source = "imageName")
    @Mapping(target = "image", source = "imageData", qualifiedByName = "wtf")
    @Mapping(target = "type", source = "imageExtension")
    Image toEntity(ImageDto imageDto);

    ImageDto toDTO(Image image);

    @Named("wtf")
    static byte[] wtf(String dtoDate){
        String base64String = dtoDate.split(",")[1];
        byte[] data = Base64.getDecoder().decode(base64String);
        return data;
    }
}
