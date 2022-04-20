package com.allteran.mirage.rootservice.repo;

import com.allteran.mirage.rootservice.domain.PointOfSales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface POSRepository extends JpaRepository<PointOfSales, String> {
    PointOfSales findPointOfSalesById(String id);
}
