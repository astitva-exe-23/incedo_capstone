package com.telecomw.telecom_usage_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "customer-service")
public interface CustomerClient {

    @PutMapping("/customers/{id}/wallet/deduct")
    void deductWallet(@PathVariable("id") Long customerId,
                      @RequestParam("amount") Double amount);
}
