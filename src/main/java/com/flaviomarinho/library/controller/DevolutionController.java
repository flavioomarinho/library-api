package com.flaviomarinho.library.controller;


import com.flaviomarinho.library.dto.DevolutionDTO;
import com.flaviomarinho.library.model.Devolution;
import com.flaviomarinho.library.service.DevolutionService;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("devolution")
public class DevolutionController {

    private DevolutionService devolutionService;

    public DevolutionController(DevolutionService devolutionService) {
        this.devolutionService = devolutionService;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Long update(@RequestBody DevolutionDTO dto) {
        Devolution devolution = devolutionService.update(dto);
        return devolution.getId();
    }
}