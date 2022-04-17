package com.allteran.mirage.warehouseservice.service;

import com.allteran.mirage.warehouseservice.repo.DeviceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceTypeService {
    private final DeviceTypeRepository typeRepo;

    @Autowired
    public DeviceTypeService(DeviceTypeRepository typeRepo) {
        this.typeRepo = typeRepo;
    }
}
