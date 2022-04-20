package com.allteran.mirage.rootservice.repo;

import com.allteran.mirage.rootservice.domain.POSType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface POSTypeRepository extends JpaRepository<POSType, String> {
    POSType findPOSTypeById(String id);
}
