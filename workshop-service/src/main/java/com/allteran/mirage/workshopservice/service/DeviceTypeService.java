package com.allteran.mirage.workshopservice.service;

import com.allteran.mirage.workshopservice.domain.DeviceType;
import com.allteran.mirage.workshopservice.repo.DeviceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceTypeService {
    private final DeviceTypeRepository typeRepo;

    @Autowired
    public DeviceTypeService(DeviceTypeRepository typeRepo) {
        this.typeRepo = typeRepo;
    }

    public List<DeviceType> findAll() {
        return typeRepo.findAll();
    }

    public DeviceType findById(Long id) {
        return typeRepo.findDeviceTypeById(id);
    }


    public DeviceType create(DeviceType type) {
        return typeRepo.save(type);
    }

    public DeviceType update(DeviceType typeFromDb, DeviceType type) {
        typeFromDb.setName(type.getName());
        return typeRepo.save(typeFromDb);
    }

    public void delete(DeviceType type) {
        typeRepo.delete(type);
    }
}
