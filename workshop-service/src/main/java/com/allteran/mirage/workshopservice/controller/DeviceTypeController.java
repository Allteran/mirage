package com.allteran.mirage.workshopservice.controller;

import com.allteran.mirage.workshopservice.domain.DeviceType;
import com.allteran.mirage.workshopservice.service.DeviceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/workshop/device-type")
public class DeviceTypeController {
    private final DeviceTypeService typeService;

    @Autowired
    public DeviceTypeController(DeviceTypeService typeService) {
        this.typeService = typeService;
    }

    @GetMapping
    public List<DeviceType> findAll() {
        return typeService.findAll();
    }

    @PostMapping("new")
    public DeviceType create(@RequestBody DeviceType type) {
        return typeService.create(type);
    }

    @PutMapping("{id}")
    public DeviceType update(@PathVariable("id")DeviceType typeFromDb, @RequestBody DeviceType type) {
        return typeService.update(typeFromDb, type);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") DeviceType type) {
        typeService.delete(type);
    }
}
