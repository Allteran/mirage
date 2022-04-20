package com.allteran.mirage.rootservice.service;

import com.allteran.mirage.rootservice.domain.PointOfSales;
import com.allteran.mirage.rootservice.repo.POSRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class POSService {
    private final POSRepository posRepo;

    @Autowired
    public POSService(POSRepository posRepo) {
        this.posRepo = posRepo;
    }

    public PointOfSales findById(String id) {
        return posRepo.findPointOfSalesById(id);
    }

    public List<PointOfSales> findAll() {
        return posRepo.findAll();
    }

    public PointOfSales create(PointOfSales pointOfSales) {
        return posRepo.save(pointOfSales);
    }

    public PointOfSales update(PointOfSales posFromDb, PointOfSales pos) {
        BeanUtils.copyProperties(pos, posFromDb, "id");
        return posRepo.save(posFromDb);
    }

    public void delete(PointOfSales pos) {
        posRepo.delete(pos);
    }
}
