package com.example.onlineshop.service.impl;

import com.example.onlineshop.dto.StatusDto;
import com.example.onlineshop.entity.Status;
import com.example.onlineshop.exception.RecordNotFoundException;
import com.example.onlineshop.mapper.StatusMapper;
import com.example.onlineshop.repositories.StatusRepo;
import com.example.onlineshop.service.StatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class StatusServiceImpl implements StatusService {
    private final StatusRepo statusRepo;
    @Override
    public StatusDto saveStatus(StatusDto statusDto) {
        Status status = StatusMapper.INSTANCE.toEntity(statusDto);
        try {
            Status statusSave = statusRepo.save(status);
            return StatusMapper.INSTANCE.toDTO(statusSave);
        } catch (RuntimeException e) {
            throw new RuntimeException("Не удалось сохранить статус в базе!", e);
        }
    }

    @Override
    public StatusDto updateStatus(StatusDto statusDto, long id) {
        Status status = this.statusRepo.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Статуса с таким id не существует!"));
        return null;
    }

    @Override
    public List<StatusDto> findAllStatus() {
        return StatusMapper.INSTANCE.toDTOList(statusRepo.findAll());
    }

    @Override
    public StatusDto getStatusById(Long id) {
        Status status = this.statusRepo.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Статуса с таким id не существует!"));
        return StatusMapper.INSTANCE.toDTO(status);
    }

    @Override
    public void deleteStatus(Long id) {
        Status status = this.statusRepo.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Статуса с таким id не существует!"));
        statusRepo.deleteById(status.getId());
    }
}
