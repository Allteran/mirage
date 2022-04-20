package com.allteran.mirage.rootservice.service;

import com.allteran.mirage.rootservice.domain.POSType;
import com.allteran.mirage.rootservice.repo.POSTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class POSTypeService {
    private final POSTypeRepository posTypeRepo;

    public POSTypeService(POSTypeRepository posTypeRepo) {
        this.posTypeRepo = posTypeRepo;
    }

    public List<POSType> findAll() {
        return posTypeRepo.findAll();
    }

    public POSType findById(String id) {
        return posTypeRepo.findPOSTypeById(id);
    }

    public POSType create(POSType posType) {
        return posTypeRepo.save(posType);
    }

    public POSType update(POSType typeFromDb, POSType posType) {
        typeFromDb.setName(posType.getName());
        return posTypeRepo.save(typeFromDb);
    }

    public void delete(POSType type) {
        posTypeRepo.delete(type);
    }
}
