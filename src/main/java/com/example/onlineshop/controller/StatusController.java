package com.example.onlineshop.controller;


import com.example.onlineshop.dto.StatusDto;
import com.example.onlineshop.service.StatusService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.onlineshop.config.SwaggerConfig.STATUS;

@Api(tags = STATUS)
@AllArgsConstructor
@RestController
@RequestMapping("/status")
public class StatusController {
    private final StatusService statusService;
    @PostMapping("/save")
    public StatusDto saveStatus(@RequestBody StatusDto statusDto){
        return statusService.saveStatus(statusDto);
    }
    @PutMapping("/update")
    public StatusDto updateStatus(@RequestBody StatusDto statusDto, @PathVariable long id){
        return statusService.updateStatus(statusDto, id);
    }
    @GetMapping("/findAll")
    public List<StatusDto> findAll(){
        return statusService.findAllStatus();
    }
    @DeleteMapping("/delete")
    public void deleteStatus(@RequestParam Long id){
        statusService.deleteStatus(id);
    }

}
