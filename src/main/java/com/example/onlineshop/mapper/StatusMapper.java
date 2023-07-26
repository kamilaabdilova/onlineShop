package com.example.onlineshop.mapper;

import com.example.onlineshop.dto.StatusDto;
import com.example.onlineshop.entity.Status;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StatusMapper {
    StatusMapper INSTANCE = Mappers.getMapper(StatusMapper.class);
    Status toEntity(StatusDto statusDto);
    StatusDto toDTO(Status status);
    List<StatusDto> toDTOList(List<Status> statusList);
}
