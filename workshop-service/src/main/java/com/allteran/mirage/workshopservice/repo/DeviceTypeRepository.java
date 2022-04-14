package com.allteran.mirage.workshopservice.repo;

import com.allteran.mirage.workshopservice.domain.DeviceType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceTypeRepository extends MongoRepository<DeviceType, Long> {

    List<DeviceType> findAll();

    DeviceType findDeviceTypeById(Long id);
}
