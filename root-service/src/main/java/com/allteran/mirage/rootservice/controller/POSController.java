package com.allteran.mirage.rootservice.controller;

import com.allteran.mirage.rootservice.domain.PointOfSales;
import com.allteran.mirage.rootservice.service.POSService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/root-service/pos")
public class POSController {
    private final POSService posService;

    public POSController(POSService posService) {
        this.posService = posService;
    }

    @GetMapping
    public List<PointOfSales> findAll() {
        return posService.findAll();
    }

    @GetMapping("{id}")
    public PointOfSales findById(@PathVariable("id") PointOfSales pos) {
        return pos;
    }

    @PostMapping("new")
    public PointOfSales create(@RequestBody PointOfSales pos) {
        return posService.create(pos);
    }

    @PutMapping("{id}")
    public PointOfSales update(@PathVariable("id") PointOfSales posFromDb,
                               @RequestBody PointOfSales pos) {
        return posService.update(posFromDb, pos);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") PointOfSales pos) {
        posService.delete(pos);
    }
}
