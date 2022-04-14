package com.allteran.mirage.workshopservice.repo;

import com.allteran.mirage.workshopservice.domain.Status;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatusRepository extends MongoRepository<Status, Long> {
    List<Status> findAll();

    Status findStatusById(Long id);
}
