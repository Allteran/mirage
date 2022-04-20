package com.allteran.mirage.rootservice.controller;

import com.allteran.mirage.rootservice.domain.POSType;
import com.allteran.mirage.rootservice.service.POSTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/root-service/pos-type")
public class POSTypeController {
    private final POSTypeService typeService;

    @Autowired
    public POSTypeController(POSTypeService posTypeService) {
        this.typeService = posTypeService;
    }

    @GetMapping
    public List<POSType> findAll() {
        return typeService.findAll();
    }

    @GetMapping("{id}")
    public POSType findById(@PathVariable("id")POSType posType) {
        return posType;
    }

    @PostMapping("new")
    public POSType createPOSType(@RequestBody POSType posType) {
        return typeService.create(posType);
    }

    @PutMapping("{id}")
    public POSType updatePOSType(@PathVariable("id") POSType typeFromDb,
                                 @RequestBody POSType type) {
        return typeService.update(typeFromDb, type);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") POSType type) {
        typeService.delete(type);
    }
}
