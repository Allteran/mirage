package com.allteran.mirage.rootservice.controller;

import com.allteran.mirage.rootservice.domain.Dealer;
import com.allteran.mirage.rootservice.service.DealerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/root-service/dealer")
public class DealerController {
    private final DealerService dealerService;

    @Autowired
    public DealerController(DealerService dealerService) {
        this.dealerService = dealerService;
    }

    @GetMapping
    public List<Dealer> findAll() {
        return dealerService.findAll();
    }

    @GetMapping("id={id}")
    public Dealer findById(@PathVariable("id") Dealer dealer) {
        return dealer;
    }

    @GetMapping("inn={inn}")
    public Dealer findByInn(@PathVariable("inn") String inn) {
        return dealerService.findByInn(inn);
    }

    @PostMapping("new")
    public Dealer createDealer(@RequestBody Dealer dealer) {
        return dealerService.create(dealer);
    }

    @PutMapping("{id}")
    public Dealer updateDealer(@PathVariable("id") Dealer dealerFromDb,
                               @RequestBody Dealer dealer) {
        return dealerService.update(dealerFromDb, dealer);
    }

    @DeleteMapping("delete/{id}")
    public void deleteDealer(@PathVariable("id") Dealer dealer) {
        dealerService.delete(dealer);
    }
}
