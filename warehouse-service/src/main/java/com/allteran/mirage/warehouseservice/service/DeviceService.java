package com.allteran.mirage.warehouseservice.service;

import com.allteran.mirage.warehouseservice.domain.Device;
import com.allteran.mirage.warehouseservice.repo.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService {
    private final DeviceRepository deviceRepo;
    private final DeviceTypeService typeService;

    @Autowired
    public DeviceService(DeviceRepository deviceRepo, DeviceTypeService typeService) {
        this.deviceRepo = deviceRepo;
        this.typeService = typeService;
    }

    public List<Device> findAll() {
        return deviceRepo.findAll();
    }
}
