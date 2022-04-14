package com.allteran.mirage.workshopservice.controller;

import com.allteran.mirage.workshopservice.domain.Status;
import com.allteran.mirage.workshopservice.service.StatusService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/workshop/status")
public class StatusController {
    private final StatusService statusService;

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping
    public List<Status> findAll() {
        return statusService.findAll();
    }

    @PostMapping("new")
    public Status create(@RequestBody Status status) {
        return statusService.create(status);
    }

    @PutMapping("{id}")
    public Status update(@PathVariable("id")Status statusFromDb, @RequestBody Status status) {
        return statusService.update(statusFromDb, status);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Status status) {
        statusService.delete(status);
    }
}
