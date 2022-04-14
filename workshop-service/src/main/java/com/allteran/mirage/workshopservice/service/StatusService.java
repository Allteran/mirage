package com.allteran.mirage.workshopservice.service;

import com.allteran.mirage.workshopservice.domain.Status;
import com.allteran.mirage.workshopservice.repo.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {
    private final StatusRepository statusRepo;

    @Autowired
    public StatusService(StatusRepository statusRepo) {
        this.statusRepo = statusRepo;
    }

    public List<Status> findAll() {
        return statusRepo.findAll();
    }

    public Status create(Status status) {
        return statusRepo.save(status);
    }

    public Status update(Status statusFromDb, Status status) {
        statusFromDb.setName(status.getName());
        return statusRepo.save(statusFromDb);
    }

    public void delete(Status status) {
        statusRepo.delete(status);
    }
}
