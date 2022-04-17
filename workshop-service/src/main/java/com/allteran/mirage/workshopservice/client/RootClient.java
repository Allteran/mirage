package com.allteran.mirage.workshopservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "root-service")
public interface RootClient {
    @GetMapping("/api/v1/root/user/{id}")
    String getUserFullName(@PathVariable("id") String id);
}
