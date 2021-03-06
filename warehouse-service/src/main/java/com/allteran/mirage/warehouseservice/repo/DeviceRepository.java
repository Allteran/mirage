package com.allteran.mirage.warehouseservice.repo;

import com.allteran.mirage.warehouseservice.domain.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {

}
