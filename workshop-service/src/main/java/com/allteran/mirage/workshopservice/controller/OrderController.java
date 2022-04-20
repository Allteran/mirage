package com.allteran.mirage.workshopservice.controller;

import com.allteran.mirage.workshopservice.client.RootClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreaker;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Supplier;

@RestController
@RequestMapping("api/v1/workshop/order")
public class OrderController {
    private final RootClient rootClient;
    private final Resilience4JCircuitBreakerFactory circuitBreakerFactory;

    @Autowired
    public OrderController(RootClient rootClient, Resilience4JCircuitBreakerFactory circuitBreakerFactory) {
        this.rootClient = rootClient;
        this.circuitBreakerFactory = circuitBreakerFactory;
    }

    @GetMapping("test/{id}")
    public String getTestUser (@PathVariable("id") String userId) {
        return rootClient.getUserFullName(userId);
    }

    @GetMapping("otest")
    public String getTestInfo() {
        Resilience4JCircuitBreaker circuitBreaker = circuitBreakerFactory.create("root");
        Supplier<String> resultStringSupplier = rootClient::getTestData;

        String resultString = circuitBreaker.run(resultStringSupplier, this::handleErrorCase);
        return resultString;
    }

    private String handleErrorCase(Throwable t) {
        t.printStackTrace();
        return "error";
    }
}
