package com.allteran.mirage.rootservice.repo;

import com.allteran.mirage.rootservice.domain.Dealer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealerRepository extends JpaRepository<Dealer, String> {
    Dealer findDealerById(String id);
    Dealer findDealerByInn(String inn);
}
