package com.allteran.mirage.rootservice.service;

import com.allteran.mirage.rootservice.domain.Dealer;
import com.allteran.mirage.rootservice.repo.DealerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DealerService {
    private final DealerRepository dealerRepo;

    @Autowired
    public DealerService(DealerRepository dealerRepo) {
        this.dealerRepo = dealerRepo;
    }

    public Dealer findById(String id) {
        return dealerRepo.findDealerById(id);
    }

    public Dealer findByInn(String inn) {
        return dealerRepo.findDealerById(inn);
    }

    public List<Dealer> findAll() {
        return dealerRepo.findAll();
    }

    public Dealer create(Dealer dealer) {
        return dealerRepo.save(dealer);
    }

    public Dealer update(Dealer dealerFromDb, Dealer dealer) {
        dealerFromDb.setInn(dealer.getInn());
        dealerFromDb.setName(dealer.getName());

        return dealerRepo.save(dealerFromDb);
    }

    public void delete(Dealer dealer) {
        dealerRepo.delete(dealer);
    }
}
