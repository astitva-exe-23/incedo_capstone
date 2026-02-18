package com.telecomw.portfolio_service.client;


import com.telecomw.portfolio_service.dto.CustomerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service")
public interface CustomerClient {


    @GetMapping("/customers/{id}")
    CustomerDTO getCustomer(@PathVariable Long id);
}
