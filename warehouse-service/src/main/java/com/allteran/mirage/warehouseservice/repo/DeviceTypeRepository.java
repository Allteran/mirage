package com.allteran.mirage.warehouseservice.repo;

import com.allteran.mirage.warehouseservice.domain.DeviceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceTypeRepository extends JpaRepository<DeviceType, Long> {
}
